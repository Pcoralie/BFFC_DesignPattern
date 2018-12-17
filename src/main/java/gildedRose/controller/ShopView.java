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
import javafx.scene.chart.*;
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

    @FXML
    BarChart<String, Number> bc;
    @FXML
    CategoryAxis xAxis;
    @FXML
    NumberAxis yAxis;

    @FXML
    BarChart<String, Number> barChartSI;


    Inventory globalInventory = new Inventory(new Item[0]);
    Inventory supplierInventory = new Inventory(new Item[0]);
    ArrayList<Item> InventaireBuy = new ArrayList<>();
    ArrayList<Item> InventaireSell = new ArrayList<>();



    int date = 0;

    // Constructor
    public ShopView() {
        this.globalInventory = new Inventory(new Item[0]);
        this.date = 0;
    }

    //getters and setters

    public Inventory getGlobalInventory() {
        return globalInventory;
    }

    public void setGlobalInventory(Inventory globalInventory) {
        this.globalInventory = globalInventory;
    }

    public BarChart<String, Number> getBc() { return bc; }

    public void setBc(BarChart<String, Number> bc) { this.bc = bc; }

    public PieChart getPieChart() { return pieChart; }

    public void setPieChart(PieChart pieChart) { this.pieChart = pieChart; }

    public int getDate() { return date; }

    public void setDate(int date) { this.date = date; }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        labelDate.setText("Jour : " + Integer.toString(date));
        pieChart.setVisible(false);
        bc.setVisible(false);
        barChartSI.setVisible(false);

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


    public void FetchBarChartSI(){
        Item [] items = globalInventory.getItems();
        barChartSI.autosize();

        ArrayList<Integer> SellIn = new ArrayList();
        for(Item item : items)
        {
            boolean isPresent = false;
            for(Integer integer: SellIn)
            {
                if(integer.equals(item.getSellIn()))
                {
                    isPresent = true;
                }
            }
            if(!isPresent)
            {
                SellIn.add(item.getSellIn());
            }
        }
        Collections.sort(SellIn);

        ArrayList<Integer> NumberOfItems = new ArrayList();
        for (Integer integer: SellIn)
        {
            int nb = 0;
            for(Item item : items)
            {
                if (integer.equals(item.getSellIn()))
                {
                    nb++;
                }
            }
            NumberOfItems.add(nb);
        }

        XYChart.Series serie = new XYChart.Series();
        for (int i = 0 ; i < SellIn.size() ; i++){
            serie.getData().add(new XYChart.Data(SellIn.get(i).toString(), NumberOfItems.get(i)));
            System.out.println( SellIn.get(i) + ", " + NumberOfItems.get(i));
        }
        barChartSI.getData().setAll(serie);
    }

    public void FetchBarChartCreationDate(){
        Item [] items = globalInventory.getItems();
        bc.autosize();

        //CategoryAxis xAxis = new CategoryAxis();
        //NumberAxis yAxis = new NumberAxis();
        //BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        //bc = new BarChart<String, Number>(xAxis, yAxis);
        //bc.setTitle("Number of Items by creation date");
        //xAxis.setLabel("creation date");
        //yAxis.setLabel("number of items");
      /*
        ArrayList<String> dates = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");*/
        
        ArrayList<Calendar> dates = new ArrayList<>();
        for (Item i : items ) {
            boolean isPresent = false;
            for ( Calendar s : dates){
                if ( s.equals(i.getCreationDate())) {
                    isPresent = true;
                }
            }
            if (!isPresent){
                dates.add(i.getCreationDate());
            }
        }

        Collections.sort(dates);

        ArrayList<Integer> number = new ArrayList();
        for (Calendar s : dates){
            int nb = 0;
            for (Item i : items ){
                if ( i.getCreationDate().equals(s)){
                    nb= nb +1 ;
                }
            }
            number.add(nb);
        }
        XYChart.Series serie = new XYChart.Series();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0 ; i < dates.size() ; i++){
            String creationDate = sdf.format(dates.get(i).getTime());
            serie.getData().add(new XYChart.Data(creationDate, number.get(i)));
            System.out.println( creationDate + ", " + number.get(i));
        }
        bc.getData().setAll(serie);

    }

    public void OnUpdate()
    {
        globalInventory.updateQuality();
        date = date + 1;
        labelDate.setText("Jour : " + Integer.toString(date));
        fetchItems();
        fetchPiechart();
        pieChart.setVisible(true);
        FetchBarChartCreationDate();
        bc.setVisible(true);
        FetchBarChartSI();
        barChartSI.setVisible(true);

    }

    public File ChooseFile(){
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

        File file = chooser.getSelectedFile();
        return file;
    }



    public void OnLoadFile(){
        JSONParser parser = new JSONParser();
            File jsonFile = ChooseFile();


        try {JSONArray inventory = (JSONArray) parser.parse(new FileReader( jsonFile));
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
            FetchBarChartCreationDate();
            bc.setVisible(true);
            FetchBarChartSI();
            barChartSI.setVisible(true);

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
        InventaireBuy.add(globalInventory.getItem(indexItemSelected));
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
        FetchBarChartCreationDate();
        bc.setVisible(true);
        FetchBarChartSI();
        barChartSI.setVisible(true);
        for(int i = 0; i < InventaireBuy.size(); i++)
        {
            System.out.println(InventaireBuy.get(i).toString());
        }
    }

    public void OnSellItem()
    {
        int indexItemSelected = listViewShop.getSelectionModel().getSelectedIndex();
        InventaireSell.add(globalInventory.getItem(indexItemSelected));
        globalInventory.deleteItem(indexItemSelected);
        fetchItems();
        fetchSupplier();
        fetchPiechart();
        pieChart.setVisible(true);
        FetchBarChartCreationDate();
        bc.setVisible(true);
        FetchBarChartSI();
        barChartSI.setVisible(true);
        for(int i = 0; i < InventaireSell.size(); i++)
        {
            System.out.println(InventaireSell.get(i).toString());
        }
    }
}
