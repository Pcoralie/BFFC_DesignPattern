package GUI;

import Classes.Inventory;
import Classes.Item;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListItemController extends Application implements Initializable {

    private Stage primaryStage;
    @FXML private Pane root;

    @FXML private ScrollPane listItem;

    private Inventory inventory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listItem = new ScrollPane();

        this.inventory = new Inventory();

        for(Item i : inventory.getItems())
        {
            FXMLLoader itemView = new FXMLLoader();
            itemView.setLocation(getClass().getResource("ItemView.fxml"));

            ItemViewController itemController = itemView.getController();

            try {
                AnchorPane item = itemView.load();
                itemController.setName(i.getName());

                listItem.setContent(item);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Items");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ListItem.fxml"));
        this.root = loader.load();
        Scene scene = new Scene(new AnchorPane());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
