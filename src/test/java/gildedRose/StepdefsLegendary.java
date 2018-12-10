package gildedRose;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StepdefsLegendary {
    private Inventory inventory;
    private Item[] items ;
    private Item legendary;

    @Given("^I have a new inventoryC$")
    public void iHaveANewInventoryC() {
        inventory = new Inventory();
        items = inventory.getItems();
        legendary = items[3];
    }

    @Then("^the quality of the legendary item is initialized as (\\d+)$")
    public void theQualityOfTheLegendaryIs( int legendaryQuality) {
        assertThat(legendary.getQuality(), is(legendaryQuality));
    }

    @When("^I update the inventoryC$")
    public void iUpdateTheInventoryC() {
        inventory.updateQuality();
    }

    @Then("^the quality of the legendary item is (\\d+)$")
    public void theQualityOfTheLegendaryItemIs(int legendaryQuality) {
        assertThat(legendary.getQuality(), is(legendaryQuality));
    }
}
