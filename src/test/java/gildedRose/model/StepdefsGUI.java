package gildedRose.model;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gildedRose.controller.ShopView;
import javafx.scene.chart.PieChart;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StepdefsGUI {


    private ShopView shopview = new ShopView();
    private Inventory inventory = this.shopview.getGlobalInventory();
    private Item[] items = inventory.getItems();
    private PieChart piechart = shopview.getPieChart();

/*
    @Given("^I choose a json file$")
    public void i_choose_a_json_file() throws Throwable {


        assertThat(shopview.ChooseFile(), is("<C:\\Users\\Utilisateur\\Documents\\ESILV\\S07\\DesignPatternAndSoftDev\\BFFC_DesignPattern\\inventory.json>"));
        throw new PendingException();

    }
*/

        @Given("^I have an empty Inventory$")
        public void the_inventory_is (){
             inventory = new Inventory(new Item[0]);
        }

        /*
        @Then("^The piechart is empty$")
        public void the_piechart_is_empty(){
            assertNull(piechart);
        }
*/
        //@Then("^the barchart is empty$")


        @When("^the user click on the load file button$")
        public void userClickButtonLoadFile () {
            shopview.OnLoadFile();
        }

        @Then("^items are add to the inventory$")
        public void itemsAreAddToTheInventory () {
            items = shopview.getGlobalInventory().getItems();
            assertThat(items[0].getName(), is( "+5 Dexterity Vest"));
            //assertThat(shopview.getGlobalInventory(), is(inventory));
        }

/*
        @Then("^the piechart is updated$")
        public void piechartIsUpdated(){
            piechart = shopview.getPieChart();
            PieChart pie = new PieChart();
            assertNotSame(pie, piechart);

        }
        */
    }


