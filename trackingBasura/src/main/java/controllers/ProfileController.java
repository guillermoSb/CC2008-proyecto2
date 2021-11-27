package controllers;

// importar los paquetes de javafx
import interfaces.GoBack;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.DatabaseManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * clase que controla el perfil del usuario, incorporando botones para hacer los request
 */
public class ProfileController implements GoBack, Initializable {
    @FXML
    Button regresarButton;

    @FXML
    Label puntosLabel;

    @FXML
    public void regresarButtonClicked() throws IOException {
        this.goBack();
    }

    /**
     * incorporar el boton de regresar
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
    * metodo para inicar este frame
    * como parametros se requiere el url y el paquete de propiedades
    */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int puntos = DatabaseManager.shared.getPuntosUsuario();
        puntosLabel.setText(String.format("Tus puntos: %d", puntos));
    }
}
