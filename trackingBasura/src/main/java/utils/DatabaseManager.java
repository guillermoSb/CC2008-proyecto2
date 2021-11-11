package utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import models.Usuario;
import org.bson.Document;

/**
 * Manager para la base de datos de MongoDb
 */
public class DatabaseManager {
    public static DatabaseManager shared = new DatabaseManager();   // Instancia Compartida de este servicio
    private MongoDatabase database;
    private DatabaseManager() {
        var connectionString = new ConnectionString("mongodb+srv://guillermo:POO2021@cluster0.mbkct.mongodb.net/tracker?retryWrites=true&w=majority");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("tracker");
        this.database = database;   // Guardar la base de datos en la variable
        MongoCollection col = database.getCollection("productos");

    }

    /**
     * Inicia sesión de un nuevo usuario
     * @param username
     * @param password
     */
    public Usuario loginUser(String username, String password) {
        MongoCollection users = database.getCollection("usuarios");    // Coleccion de usuarios
        Document mongoUserDoc = (Document) users.find(and(eq("username", username), eq("password", password))).first();
        if (mongoUserDoc == null) {
            return null;
        }
        //  Crear un objeto de tipo usuario
        Usuario usuario = new Usuario("test", "test","34", "23", 1);
        // Regresar el usuario
        return  usuario;
    }

    /**
     * Registra un nuevo usuario en el proyecto
     * @param username
     * @param password
     */
    public boolean registerUser(String username, String password) {
        MongoCollection users = database.getCollection("usuarios");    // Coleccion de usuarios
        Document doc = new Document();
        doc.append("username", username);
        doc.append("password", password);
        users.insertOne(doc);   // Guardar el usuario
        return true;
    }
}
