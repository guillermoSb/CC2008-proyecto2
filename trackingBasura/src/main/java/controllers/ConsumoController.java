package controllers;

// se importan las librerias utilizadas para la GUI
import interfaces.GoBack;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Consumo;
import models.Producto;
import utils.DatabaseManager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Clase que se encarga de ingresar consumos al programa
 */
public class ConsumoController implements GoBack, Initializable {

    HashMap<String, String> productosMap;
    ArrayList<Producto> productos = new ArrayList<>();

    @FXML
    Button regresarButton;

    @FXML
    Button registrarConsumoButton;

    @FXML
    ChoiceBox choiceBoxField;

    @FXML
    TextField cantidadField;

    @FXML
    public void regresarButtonClicked() throws IOException {
        this.goBack();
    }

    /**
     * metodo que se encarga de registrar consumos en la base de datos con el boton asignado
     */
    @FXML
    public void registrarConsumoButtonClicked()  {
        if (cantidadField.getText().length() <= 0) {
            return;
        }
        // Crear el consumo en la base de datos
        Producto producto = null;
        // Obtener el producto que el usuario selecciono
        for (int i = 0; i < this.productos.size(); i++) {
            if (this.productos.get(i).getNombre().equals(this.choiceBoxField.getValue())) {
                producto = this.productos.get(i);
            }
        }
        Consumo consumo = new Consumo(producto, Integer.parseInt(cantidadField.getText()), "");
        DatabaseManager.shared.crearConsumo(consumo);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Consumo");
        a.setContentText("Has ingresado un consumo exitosamente.");
        a.setHeaderText("");
        a.show();

    }

    /**
     * metodo que se encarga de darle funcionalidad al boton de regresar
     * @throws IOException
     */
    public void goBack() throws IOException {
        Stage stage = (Stage) regresarButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/dashboard.fxml"));
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }

    /**
     * metodo que se encarga de recoger los datos de la base de datos para hacer un consumo
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Cargar arreglo de productos de la base de datos
        ArrayList<Producto> productos = DatabaseManager.shared.getProductos();
        this.productos = productos;
        for (int i = 0; i < productos.size(); i++) {
        // this.productosMap.put(productos.get(i).getNombre(), productos.get(i).get_id());
            choiceBoxField.getItems().add(productos.get(i).getNombre());
            choiceBoxField.setValue(productos.get(0).getNombre());
        }

    }
}
