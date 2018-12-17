package gildedRose.controller;

import gildedRose.model.*;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.*;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;

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
    @FXML
    ListView listViewSupplierInventory;
    @FXML
    Button buttonBuyItem;
    @FXML
    Button buttonSellItem;

    Inventory globalInventory = new Inventory(new Item[0]);
    Inventory supplierInventory = new Inventory(new Item[0]);

    int date = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        labelDate.setText("Jour : " + Integer.toString(date));
        pieChart.setVisible(false);

        //fetchItems();
        //fetchPiechart();
        loadSupplier();

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
        Item [] items = globalInventory.getItems();
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
        pieChart.setVisible(true);
    }

    public void OnLoadFile(){
        JSONParser parser = new JSONParser();
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        //chooser.setDialogTitle("Browse the folder to process");
        //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }

        try {JSONArray inventory = (JSONArray) parser.parse(new FileReader( chooser.getSelectedFile()));
        //try{ JSONArray inventory = (JSONArray) parser.parse(new FileReader("inventory.json"));
            /*JSONObject jsonObject =(JSONObject) obj;
            JSONArray inventory =(JSONArray) jsonObject.get("inventory");
            System.out.println("\nInventory:");
            Iterator<Item> iterator = inventory.iterator();*/

            for(Object o : inventory)
            {

               JSONObject item = (JSONObject) o;
               String name = (String) item.get("name");
               Integer sellin = (int) (long)item.get("sellIn");
               Integer quality = (int) (long)item.get("quality");

               Calendar calendar = Calendar.getInstance();
               String dateOfCreation = (String) item.get("date");
               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
               calendar.setTime(sdf.parse(dateOfCreation));


               if(name.toLowerCase().contains("elixir"))
               {
                   Elixir newElixir = new Elixir(name, sellin, quality, calendar);
                   globalInventory.addItem(newElixir);

               }
               if(name.toLowerCase().contains("dexterity"))
               {
                   Dexterity newDexterity = new Dexterity(name, sellin, quality, calendar);
                   globalInventory.addItem(newDexterity);
               }
               if(name.toLowerCase().contains("aged"))
               {
                   Cheese newCheese = new Cheese(name, sellin, quality, calendar);
                   globalInventory.addItem(newCheese);
               }
               if(name.toLowerCase().contains("conjured"))
               {
                   Conjured newConjured = new Conjured(name, sellin, quality, calendar);
                   globalInventory.addItem(newConjured);
               }
               if(name.toLowerCase().contains("backstage"))
               {
                   BackstagePass newBackstage = new BackstagePass(name, sellin, quality, calendar);
                   globalInventory.addItem(newBackstage);
               }
               if(name.toLowerCase().contains("sulfuras"))
               {
                   Legendary newLegendary = new Legendary(name, sellin, quality, calendar);
                   globalInventory.addItem(newLegendary);
               }



            }
            fetchPiechart();
            pieChart.setVisible(true);
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

    public void fetchSupplier()
    {
        ObservableList<String> allItems;
        ArrayList<String> itemsToFetch = new ArrayList<String>();



        for(int i = 0; i<supplierInventory.getItems().length; i++)
        {
            itemsToFetch.add(supplierInventory.getItems()[i].toString());
        }
        allItems = FXCollections.observableArrayList(itemsToFetch);
        listViewSupplierInventory.setItems(allItems);
    }


    public void loadSupplier()
    {
        JSONParser parser = new JSONParser();


        try {
        JSONArray inventory = (JSONArray) parser.parse(new FileReader("inventory.json"));


            for(Object o : inventory)
            {

                JSONObject item = (JSONObject) o;
                String name = (String) item.get("name");
                Integer sellin = (int) (long)item.get("sellIn");
                Integer quality = (int) (long)item.get("quality");

                Calendar calendar = Calendar.getInstance();
                String dateOfCreation = (String) item.get("date");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                calendar.setTime(sdf.parse(dateOfCreation));


                if(name.toLowerCase().contains("elixir"))
                {
                    Elixir newElixir = new Elixir(name, sellin, quality, calendar);
                    supplierInventory.addItem(newElixir);
                }
                if(name.toLowerCase().contains("dexterity"))
                {
                    Dexterity newDexterity = new Dexterity(name, sellin, quality, calendar);
                    supplierInventory.addItem(newDexterity);
                }
                if(name.toLowerCase().contains("aged"))
                {
                    Cheese newCheese = new Cheese(name, sellin, quality, calendar);
                    supplierInventory.addItem(newCheese);
                }
                if(name.toLowerCase().contains("conjured"))
                {
                    Conjured newConjured = new Conjured(name, sellin, quality, calendar);
                    supplierInventory.addItem(newConjured);
                }
                if(name.toLowerCase().contains("backstage"))
                {
                    BackstagePass newBackstage = new BackstagePass(name, sellin, quality, calendar);
                    supplierInventory.addItem(newBackstage);
                }
                if(name.toLowerCase().contains("sulfuras"))
                {
                    Legendary newLegendary = new Legendary(name, sellin, quality, calendar);
                    supplierInventory.addItem(newLegendary);
                }

                fetchSupplier();


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


    public void OnBuyItem()
    {
        int indexItemSelected = listViewSupplierInventory.getSelectionModel().getSelectedIndex();
        if(supplierInventory.getItems()[indexItemSelected] instanceof Cheese)
        {
            Item itemSelected = supplierInventory.getItems()[indexItemSelected];
            globalInventory.addItem(new Cheese(itemSelected.getName(), itemSelected.getSellIn(), itemSelected.getQuality(), itemSelected.getCreationDate()));
        }
        if(supplierInventory.getItems()[indexItemSelected] instanceof Conjured)
        {
            Item itemSelected = supplierInventory.getItems()[indexItemSelected];
            globalInventory.addItem(new Conjured(itemSelected.getName(), itemSelected.getSellIn(), itemSelected.getQuality(), itemSelected.getCreationDate()));

        }
        if(supplierInventory.getItems()[indexItemSelected] instanceof BackstagePass)
        {
            Item itemSelected = supplierInventory.getItems()[indexItemSelected];
            globalInventory.addItem(new BackstagePass(itemSelected.getName(), itemSelected.getSellIn(), itemSelected.getQuality(), itemSelected.getCreationDate()));

        }
        if(supplierInventory.getItems()[indexItemSelected] instanceof Dexterity)
        {
            Item itemSelected = supplierInventory.getItems()[indexItemSelected];
            globalInventory.addItem(new Dexterity(itemSelected.getName(), itemSelected.getSellIn(), itemSelected.getQuality(), itemSelected.getCreationDate()));

        }
        if(supplierInventory.getItems()[indexItemSelected] instanceof Elixir)
        {
            Item itemSelected = supplierInventory.getItems()[indexItemSelected];
            globalInventory.addItem(new Elixir(itemSelected.getName(), itemSelected.getSellIn(), itemSelected.getQuality(), itemSelected.getCreationDate()));

        }
        if(supplierInventory.getItems()[indexItemSelected] instanceof Legendary)
        {
            Item itemSelected = supplierInventory.getItems()[indexItemSelected];
            globalInventory.addItem(new Legendary(itemSelected.getName(), itemSelected.getSellIn(), itemSelected.getQuality(), itemSelected.getCreationDate()));

        }

        fetchItems();
        fetchSupplier();
        fetchPiechart();
        pieChart.setVisible(true);
    }

    public void OnSellItem()
    {
        int indexItemSelected = listViewShop.getSelectionModel().getSelectedIndex();
        globalInventory.deleteItem(indexItemSelected);
        fetchItems();
        fetchSupplier();
        fetchPiechart();
        pieChart.setVisible(true);
    }



    
}
