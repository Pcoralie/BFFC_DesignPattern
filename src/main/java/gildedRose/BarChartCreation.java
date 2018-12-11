package gildedRose;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class BarChartCreation extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    public void start(Stage stage){
        Inventory inventory = new Inventory();
        stage.setTitle("Bar Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Number of Items by creation date");
        xAxis.setLabel("creation date");
        yAxis.setLabel("number of items");

        Item[] items = inventory.getItems();

        for (Item i : items ) {


        }
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll();
        stage.setScene(scene);
        stage.show();

    }
}
