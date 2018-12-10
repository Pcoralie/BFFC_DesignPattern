package GUI;

import Classes.Item;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemViewController implements Initializable {

    @FXML private Label name;
    @FXML private Label sellIn;
    @FXML private Label quality;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public Label getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public Label getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn.setText(Integer.toString(sellIn));
    }

    public Label getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality.setText(Integer.toString(quality));
    }
}
