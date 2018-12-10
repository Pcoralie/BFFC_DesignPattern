package gildedRose;

import javafx.fxml.Initializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
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

public class ShopView implements Initializable {

    @FXML
    ListView<String> listViewShop;

    @FXML
    Label labelShopItems;

    @FXML
    Button buttonUpdate;

    Inventory inventory = new Inventory();
    Item[] items = inventory.getItems();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
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
        fetchItems();
    }

    
}
