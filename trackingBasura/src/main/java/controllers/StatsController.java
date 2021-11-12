package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StatsController implements Initializable {

    @FXML
    BorderPane statsBorderPane;

    /**
     * Dibuja un Pie Chart
     */
    private void drawPieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Plastico", 3000),
                new PieChart.Data("Carton", 4000),
                new PieChart.Data("Vidrio", 500)
        );
        // Create the Pie Chart Object
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Tus Consumos por Categoria");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setMaxWidth(400);
        pieChart.setMaxHeight(400);
        statsBorderPane.setCenter(pieChart); // Agregar el Pie Chart al Dashboard
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Drawing!!");
        drawPieChart();
    }
}
