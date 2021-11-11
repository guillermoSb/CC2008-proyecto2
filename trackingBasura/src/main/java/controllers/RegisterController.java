package controllers;

import interfaces.GoBack;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.DatabaseManager;

import java.io.IOException;

public class RegisterController implements GoBack {

    @FXML
    private Button registerSalirButton;

    @FXML
    private TextField registerUserTextField;

    @FXML
    private PasswordField registerPasswordTextField;

    /**
     * Crea un usuario nuevo
     */
    @FXML
    protected void registerButtonClicked() throws IOException {
        // Obtener los valores del text view
        String username = registerUserTextField.getText();
        String password = registerPasswordTextField.getText();
        // Validar los campos
        if (username.length() <= 0 || password.length() <= 0) {
            return;
        }
        // Crear la cuenta
        boolean result = DatabaseManager.shared.registerUser(username, password);
        // Mostrar mensaje de resultado
        if (result) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            // Mostrar una alerta
            a.setTitle("Bienvenido");
            a.setContentText("");
            a.setHeaderText("Has Creado una cuenta.");
            openDashboard();
            a.show();
        }
    }

    /**
     * Navega a la pagina de Login
     * @throws IOException
     */
    @FXML
    protected void registerSalirButton() throws IOException {
        this.goBack();
    }

    /**
     * Abre el dashboard principal
     * @throws IOException
     */
    protected void openDashboard() throws IOException {
        Stage stage = (Stage) registerSalirButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/dashboard.fxml"));
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }

    @Override
    public void goBack() throws IOException {
        Stage stage = (Stage) registerSalirButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }
}
