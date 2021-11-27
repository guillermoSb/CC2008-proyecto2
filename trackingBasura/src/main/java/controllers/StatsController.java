package controllers;

// se importan las librerias de javafx
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.DatabaseManager;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
* esta clase se encarga de controlar la parte de las estadisticas 
*/
public class StatsController implements Initializable {

    @FXML
    BorderPane statsBorderPane;

    @FXML
    Button regresarButton;

    @FXML
    public void regresarButtonClicked() throws IOException {
        this.goBack();
    }

    public void goBack() throws IOException {
        Stage stage = (Stage) regresarButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/dashboard.fxml"));
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }

    /**
     * Dibuja un Pie Chart
     */
    private void drawPieChart() {
        HashMap<String, Double> stats = DatabaseManager.shared.getStatsPorCategoria();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Plastico", stats.get("Plastico")),
                new PieChart.Data("Papel-carton", stats.get("Papel-carton")),
                new PieChart.Data("Vidrio", stats.get("Vidrio")),
                new PieChart.Data("Organico", stats.get("Organico")),
                new PieChart.Data("Metal", stats.get("Metal"))
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

    /**
    * override del metodo de inicio 
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawPieChart();
    }
}
