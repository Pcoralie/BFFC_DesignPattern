package gildedRose;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gildedRose.model.Inventory;
import gildedRose.model.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StepdefsElixir {
    private Inventory inventory;
    private Item[] items ;
    private Item elixir;

    @Given("^I have a new inventoryD$")
    public void iHaveANewInventoryD() {
        inventory = new Inventory();
        items = inventory.getItems();
        elixir = items[2];
    }

    @Then("^the quality of the elixir item is initialized as (\\d+)$")
    public void theQualityOfTheElixirIs( int elixirQuality) {
        assertThat(elixir.getQuality(), is(elixirQuality));
    }

    @When("^I update the inventoryD$")
    public void iUpdateTheInventoryD() {
        inventory.updateQuality();
    }

    @Then("^the quality of the elixir item is (\\d+)$")
    public void theQualityOfTheElixirItemIs(int elixirQuality) {
        assertThat(elixir.getQuality(), is(elixirQuality));
    }
}
