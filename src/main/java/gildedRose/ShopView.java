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


    Inventory inventory = new Inventory();
    Item[] items = inventory.getItems();

    int date = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        labelDate.setText("Jour : " + Integer.toString(date));

        fetchItems();
    }

    public void fetchItems()
    {
        ObservableList<String> allItems;
        ArrayList<String> itemsToFetch = new ArrayList<String>();

        for(int i = 0; i<items.length; i++)
        {
            itemsToFetch.add(items[i].toString());
        }
        allItems = FXCollections.observableArrayList(itemsToFetch);
        listViewShop.setItems(allItems);

    }

    public void OnUpdate()
    {
        inventory.updateQuality();
        date = date + 1;
        labelDate.setText("Jour : " + Integer.toString(date));
        fetchItems();
    }

    public void OnLoadFile(){
        JSONParser parser = new JSONParser();
        try{ Object obj = parser.parse(new FileReader("inventory.json"));
            JSONObject jsonObject =(JSONObject) obj;
            JSONArray inventory =(JSONArray) jsonObject.get("inventory");
            System.out.println("\nInventory:");
            Iterator<Item> iterator = inventory.iterator();
            while(iterator.hasNext()) {
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



    
}
