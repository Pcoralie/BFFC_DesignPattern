package Classes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StepdefsBackstage {
    private Inventory inventory;
    private Item[] items ;
    private Item vest;
    private Item backstage;

    @Given("^I have a new inventoryB$")
    public void iHaveANewInventoryB() {
        inventory = new Inventory();
        items = inventory.getItems();
        backstage = items[4];
    }

    @Then("^the quality of the backstage item is initialized as (\\d+)$")
    public void theQualityOfTheBackstageIs( int backstageQuality) {
        assertThat(backstage.getQuality(), is(backstageQuality));
    }

    @When("^I update the inventoryB$")
    public void iUpdateTheInventoryB() {
        inventory.updateQuality();
    }

    @Then("^the quality of the backstage item is (\\d+)$")
    public void theQualityOfTheBackstageItemIs(int backstageQuality) {
        assertThat(backstage.getQuality(), is(backstageQuality));
    }
}
