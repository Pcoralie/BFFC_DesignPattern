package Classes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StepdefsCheese {
    private Inventory inventory;
    private Item[] items ;
    private Item cheese;


    @Given("^I have a new inventoryA$")
    public void iHaveANewInventoryA() {
        inventory = new Inventory();
        items = inventory.getItems();
        cheese = items[1];
    }

    @Then("^the quality of the cheese item is initialized as (\\d+)$")
    public void theQualityOfTheCheeseIs( int agedBrieQuality) {
        assertThat(cheese.getQuality(), is(agedBrieQuality));
    }

    @When("^I update the inventoryA$")
    public void iUpdateTheInventoryA() {
        inventory.updateQuality();
    }

    @Then("^the quality of the cheese item is (\\d+)$")
    public void theQualityOfTheCheeseItemIs(int cheeseQuality) {
        assertThat(cheese.getQuality(), is(cheeseQuality));
    }
}
