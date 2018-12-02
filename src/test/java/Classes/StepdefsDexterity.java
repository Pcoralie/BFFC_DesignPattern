package Classes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StepdefsDexterity {
    private Inventory inventory;
    private Item[] items ;
    private Item vest;
    private Item dexterity;

    @Given("^I have a new inventory$")
    public void iHaveANewInventory() throws Throwable {
        inventory = new Inventory();
        items = inventory.getItems();
        dexterity= items[0];
    }

    @Then("^the quality of the dexterity item is initialized as (\\d+)$")
    public void theQualityOfTheDexterityIs( int dexterityQuality) throws Throwable {
        assertThat(dexterity.getQuality(), is(dexterityQuality));
    }

    @When("^I update the inventory$")
    public void iUpdateTheInventory() throws Throwable {
        inventory.updateQuality();
    }

    @Then("^the quality of the dexterity item is (\\d+)$")
    public void theQualityOfTheDexterityItemIs(int dexterityQuality) throws Throwable {
        assertThat(dexterity.getQuality(), is(dexterityQuality));
    }
}
