package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Usuario;
import utils.DatabaseManager;

import java.io.IOException;


public class LoginController {

    @FXML
    private Button loginEntrarButton;   // Boton Login
    @FXML
    private Button loginCrearCuentaButton;  // Boton crear cuenta

    @FXML
    private TextField loginUserTextField;

    @FXML
    private PasswordField loginPasswordTextField;

    @FXML
    protected void loginButtonClicked() throws IOException {
        System.out.println("Login");
        // Obtener los valores del text view
        String username = loginUserTextField.getText();
        String password = loginPasswordTextField.getText();
        // Validar los campos
        if (username.length() <= 0 || password.length() <= 0) {
            return;
        }
        Usuario usuario = DatabaseManager.shared.loginUser(username, password);
        Alert a = new Alert(Alert.AlertType.NONE);
        // Mostrar una alerta

        // Manejar el error
        if (usuario == null) {
            // Crear una alerta de error
            a.setTitle("Error");
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("");
            a.setHeaderText("No has ingresado correctamente tus datos.");
            a.show();
        } else {
            // Iniciar dashboard principal
            openDashboard();
        }
    }

    /**
     * Navegar a la pagina de crear cuenta
     * @throws IOException
     */
    @FXML
    protected void loginCrearCuentaButtonClicked() throws IOException {
        // * Obtener la escena para crear la cuenta
        Stage stage = (Stage) loginCrearCuentaButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/register.fxml"));
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }

    /**
     * Abre el dashboard principal
     * @throws IOException
     */
    protected void openDashboard() throws IOException {
        Stage stage = (Stage) loginCrearCuentaButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/dashboard.fxml"));
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }

}
