package gildedRose;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gildedRose.model.Inventory;
import gildedRose.model.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StepdefsDexterity {
    private Inventory inventory;
    private Item[] items ;
    private Item dexterity;

    @Given("^I have a new inventoryE$")
    public void iHaveANewInventoryE() {
        inventory = new Inventory();
        items = inventory.getItems();
        dexterity = items[0];
    }

    @Then("^the quality of the dexterity item is initialized as (\\d+)$")
    public void theQualityOfTheDexterityIs( int dexterityQuality) {
        assertThat(dexterity.getQuality(), is(dexterityQuality));
    }

    @When("^I update the inventoryE$")
    public void iUpdateTheInventoryE() {
        inventory.updateQuality();
    }

    @Then("^the quality of the dexterity item is (\\d+)$")
    public void theQualityOfTheDexterityItemIs(int dexterityQuality) {
        assertThat(dexterity.getQuality(), is(dexterityQuality));
    }
}
