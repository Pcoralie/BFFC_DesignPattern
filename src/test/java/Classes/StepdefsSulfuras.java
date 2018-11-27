package Classes;

import Classes.Item;
import Classes.Sulfuras;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StepdefsSulfuras {
    private Inventory inventory;
    private Item[] items ;
    private Item vest;
    private Item sulfuras;

    @Given("^I have a new inventory$")
    public void iHaveANewInventory() throws Throwable {
        inventory = new Inventory();
        items = inventory.getItems();
        sulfuras = items[5];
    }

    @Then("^the quality of the conjured item is initialized as (\\d+)$")
    public void theQualityOfTheConjuredIs( int conjuredQuality) throws Throwable {
        assertThat(sulfuras.getQuality(), is(conjuredQuality));
    }

    @When("^I update the inventory$")
    public void iUpdateTheInventory() throws Throwable {
        inventory.updateQuality();
    }

    @Then("^the quality of the conjured item is (\\d+)$")
    public void theQualityOfTheConjuredItemIs(int conjuredQuality) throws Throwable {
        assertThat(sulfuras.getQuality(), is(conjuredQuality));
    }
}
