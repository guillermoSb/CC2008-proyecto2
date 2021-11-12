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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Consumo;
import utils.DatabaseManager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    BorderPane borderPane;

    @FXML
    Button estadisticasButton;

    @FXML
    TableView<Consumo> table;



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
        ArrayList<Consumo> consumos = DatabaseManager.shared.getConsumos();
        ObservableList<Consumo> consumosObs = FXCollections.observableArrayList();

        TableColumn<Consumo, String> prodCol = new TableColumn<>("Producto");
        prodCol.setMinWidth(100);
        prodCol.setCellValueFactory(new PropertyValueFactory<>("producto"));

        TableColumn<Consumo, String> cantCol = new TableColumn<>("Cantidad");
        cantCol.setMinWidth(100);
        cantCol.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<Consumo, String> catCol = new TableColumn<>("Categoria");
        catCol.setMinWidth(100);
        catCol.setCellValueFactory(new PropertyValueFactory<>("categoria"));



        for (int i = 0; i < consumos.size(); i++) {
            consumosObs.add(consumos.get(i));
            System.out.println("Cantidad" + consumos.get(i).getCantidad());
            System.out.println("Categoria" + consumos.get(i).getCategoria());
            System.out.println("Producto" + consumos.get(i).getProducto());
        }

        table.setItems(consumosObs);
        table.getColumns().addAll(prodCol, catCol, cantCol);
    }
}
