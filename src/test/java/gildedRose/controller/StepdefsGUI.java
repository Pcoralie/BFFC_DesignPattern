package gildedRose.controller;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gildedRose.controller.ShopView;
import gildedRose.model.Inventory;
import gildedRose.model.Item;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StepdefsGUI {


    private ShopView shopview = new ShopView();
    private Inventory inventory = this.shopview.getGlobalInventory();
    private Item[] items = inventory.getItems();
   // private PieChart piechart; /* = shopview.getPieChart();*/
    //private BarChart bc;


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
            //PieChart pie= new PieChart();
            //assertSame(piechart , pie);
           // piechart = new PieChart();
             piechart = shopview.getPieChart();
            // assertThat(piechart , is(new PieChart()));

        }

        @Then("^the barchart is empty$")
        public void the_barchart_is_empty(){
            bc = shopview.getBc();
        }
*/

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

        @Then("^there are (\\d+) items in the inventory$")
        public void there_are_x_items_in_the_inventory(int number){
            items = shopview.getGlobalInventory().getItems();
            assertThat(items.length , is(number));
        }


/*
        @Then("^the piechart is updated$")
        public void piechartIsUpdated(){
            piechart = shopview.getPieChart();
            //PieChart pie = new PieChart();
            //assertNotSame(pie, piechart);
            //assertNotNull(piechart.getData());
            assertNotNull(piechart.dataProperty());

        }*/




        @Given("^I have an inventory$")
        public void i_have_an_inventory() {
            //inventory = shopview.getGlobalInventory();
            shopview.OnLoadFile();
            items = shopview.getGlobalInventory().getItems();
        }

        @Then("^the quality of each items is initialized$")
        public void the_quality_of_each_items( ) {
            items = shopview.getGlobalInventory().getItems();
            assertThat(items[0].getQuality(), is( 20));
            assertThat(items[1].getQuality(), is(0));
            assertThat(items[5].getQuality(), is(6));
        }


        @When("^The user click on button update$")
        public void the_user_click_on_button_update() {
            //shopview.OnUpdate();
            shopview.getGlobalInventory().updateQuality();
        }

        @Then("^the quality of each items is updated$")
        public void the_quality_of_each_items_is_updated() {
            items = shopview.getGlobalInventory().getItems();
            assertThat(items[4].getQuality(), is(21));
            assertThat(items[1].getQuality(), is(1));
            assertThat(items[5].getQuality(), is(4));


        }



}


