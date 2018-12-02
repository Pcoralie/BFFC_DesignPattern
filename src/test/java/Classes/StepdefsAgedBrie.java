package Classes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StepdefsAgedBrie {
    private Inventory inventory;
    private Item[] items ;
    private Item vest;
    private Item agedBrie;

    @Given("^I have a new inventory$")
    public void iHaveANewInventory() throws Throwable {
        inventory = new Inventory();
        items = inventory.getItems();
        agedBrie = items[1];
    }

    @Then("^the quality of the aged brie item is initialized as (\\d+)$")
    public void theQualityOfTheAgedBrieIs( int agedBrieQuality) throws Throwable {
        assertThat(agedBrie.getQuality(), is(agedBrieQuality));
    }

    @When("^I update the inventory$")
    public void iUpdateTheInventory() throws Throwable {
        inventory.updateQuality();
    }

    @Then("^the quality of the aged brie item is (\\d+)$")
    public void theQualityOfTheBackstageItemIs(int agedBrieQuality) throws Throwable {
        assertThat(agedBrie.getQuality(), is(agedBrieQuality));
    }
}
