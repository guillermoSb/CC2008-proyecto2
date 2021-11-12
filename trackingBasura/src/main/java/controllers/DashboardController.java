package controllers;

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
    protected void consumoButtonClicked() throws IOException {
        Stage stage = (Stage) estadisticasButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/consumo.fxml"));
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }

    /**
     * Navegar a la pagina del perfil
     */
    @FXML
    protected void perfilButtonClicked() throws IOException {
        Stage stage = (Stage) estadisticasButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/perfil.fxml"));
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }

    /**
     * Navegar a las Estadisticas
     */
    @FXML
    protected void estadisticasButtonClicked() throws IOException {
        Stage stage = (Stage) estadisticasButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/stats.fxml"));
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
