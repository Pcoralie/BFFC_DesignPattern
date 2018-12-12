package gildedRose.model;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gildedRose.controller.ShopView;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StepdefsGUI {
    public ShopView getShopview() {
        return shopview;
    }

    public void setShopview(ShopView shopview) {
        this.shopview = shopview;
    }

    private ShopView shopview;
    private Inventory inventory = getShopview().getGlobalInventory() ;
    private Item[] items = inventory.getItems();


    @Given("^I have a json file /* */ } $")
    public void iHaveAJSONFile() {
        JSONParser parser = new JSONParser();
        try {
            JSONArray invent = (JSONArray) parser.parse(new FileReader("inventory.json"));
            Iterator<Item> iterator = invent.iterator();
            while (iterator.hasNext()) {
                System.out.println("Item  " + iterator.next());
            }
        }catch(FileNotFoundException e){
            System.out.println("json file isn't found");
            e.printStackTrace();
        }catch(IOException e ){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }catch(Exception e ){
            e.printStackTrace();
        }

    }

    @And("^the inventory is $")
    public void theInventoryIs() {
        inventory.getItems();
    }

    @When("^the user click on the load file button$")
    public void userClickButtonLoadFile(){
        shopview.OnLoadFile();
    }

    @Then("^items are add to the inventory$")
    public void itemsAreAddToTheInventory() {
        assertThat(shopview.getGlobalInventory(), is(inventory));
    }
}
