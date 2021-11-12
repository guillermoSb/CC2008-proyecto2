package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    BorderPane borderPane;

    @FXML
    Button estadisticasButton;

    /**
     * Navegar a las Estadisticas
     */
    @FXML
    protected void estadisticasButtonClicked() throws IOException {
        // BorderPane pane = FXMLLoader.load(getClass().getResource("/stats.fxml"));
        // borderPane.setRight(pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
