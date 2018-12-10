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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ShopView implements Initializable {

    @FXML
    ListView<String> shopListView;

    @FXML
    Label labelShopItems;

    @FXML
    Button buttonUpdate;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        fetchItems();
    }

    public void fetchItems()
    {
        Inventory inv = new Inventory();
        ObservableList<String> items;
        items = FXCollections.observableArrayList(inv.getItems().toString());
        shopListView.setItems(items);

    }

    
}
