package gildedRose;

import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ShopView implements Initializable {

    @FXML
    ListView<String> listViewShop;
    @FXML
    Label labelShopItems;
    @FXML
    Button buttonUpdate;
    @FXML
    Label labelDate;
    @FXML
    Button buttonLoadFile;
    @FXML
    PieChart pieChart;


    Inventory globalInventory = new Inventory(new Item[0]);



    int date = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        labelDate.setText("Jour : " + Integer.toString(date));


        //fetchItems();
        fetchPiechart();

    }

    public void fetchItems()
    {
        ObservableList<String> allItems;
        ArrayList<String> itemsToFetch = new ArrayList<String>();



        for(int i = 0; i<globalInventory.getItems().length; i++)
        {
            itemsToFetch.add(globalInventory.getItems()[i].toString());
        }
        allItems = FXCollections.observableArrayList(itemsToFetch);
        listViewShop.setItems(allItems);

    }

    public  void fetchPiechart()
    {
        int cheese = 0;
        int backstagepass = 0;
        int conjured = 0;
        int dexterity = 0;
        int elixir = 0;
        int legendary = 0;
        for (int i = 0; i < items.length; i++)
        {
            if(items[i] instanceof Cheese) cheese++;
            if(items[i] instanceof BackstagePass) backstagepass++;
            if(items[i] instanceof Conjured) conjured++;
            if(items[i] instanceof Dexterity) dexterity++;
            if(items[i] instanceof Elixir) elixir++;
            if(items[i] instanceof Legendary) legendary++;
        }
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Cheese", cheese),
                        new PieChart.Data("BackstagePass", backstagepass),
                        new PieChart.Data("Conjured", conjured),
                        new PieChart.Data("Dexterity", dexterity),
                        new PieChart.Data("Elixir", elixir),
                        new PieChart.Data("Legendary", legendary)
                );

        pieChart.setData(pieChartData);
    }

    public void OnUpdate()
    {
        globalInventory.updateQuality();
        date = date + 1;
        labelDate.setText("Jour : " + Integer.toString(date));
        fetchItems();
        fetchPiechart();
    }

    public void OnLoadFile(){
        JSONParser parser = new JSONParser();
        try{ JSONArray a = (JSONArray) parser.parse(new FileReader("inventory.json"));
            /*JSONObject jsonObject =(JSONObject) obj;
            JSONArray inventory =(JSONArray) jsonObject.get("inventory");
            System.out.println("\nInventory:");
            Iterator<Item> iterator = inventory.iterator();*/

            for(Object o : a)
            {

               JSONObject item = (JSONObject) o;
               String name = (String) item.get("name");
               Integer sellin = (int) (long)item.get("sellIn");
               Integer quality = (int) (long)item.get("quality");

               if(name.toLowerCase().contains("elixir"))
               {
                   Elixir newElixir = new Elixir(name, sellin, quality);
                   globalInventory.addItem(newElixir);
               }
               if(name.toLowerCase().contains("dexterity"))
               {
                   Dexterity newDexterity = new Dexterity(name, sellin, quality);
                   globalInventory.addItem(newDexterity);
               }
               if(name.toLowerCase().contains("aged"))
               {
                   Cheese newCheese = new Cheese(name, sellin, quality);
                   globalInventory.addItem(newCheese);
               }
               if(name.toLowerCase().contains("conjured"))
               {
                   Conjured newConjured = new Conjured(name, sellin, quality);
                   globalInventory.addItem(newConjured);
               }
               if(name.toLowerCase().contains("backstage"))
               {
                   BackstagePass newBackstage = new BackstagePass(name, sellin, quality);
                   globalInventory.addItem(newBackstage);
               }
               if(name.toLowerCase().contains("sulfuras"))
               {
                   Legendary newLegendary = new Legendary(name, sellin, quality);
                   globalInventory.addItem(newLegendary);
               }


            }

            fetchItems();



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



    
}
