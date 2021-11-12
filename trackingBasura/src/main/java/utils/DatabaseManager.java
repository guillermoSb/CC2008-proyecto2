package utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import models.Consumo;
import models.Producto;
import models.Usuario;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

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

    /**
     * Obtiene todos los productos de la base de datos
     * @return
     */
    public ArrayList<Producto> getProductos() {
        var connectionString = new ConnectionString("mongodb+srv://guillermo:POO2021@cluster0.mbkct.mongodb.net/productos?retryWrites=true&w=majority");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("productos");
        ArrayList<Producto> productos= new ArrayList<>();
        database.getCollection("productos").find().forEach(new Consumer<Document>() {
            @Override
            public void accept(Document document) {
                Producto producto = new Producto(document.getString("categoria"), document.getDouble("pesoUnitario"), document.getString("nombre"),
                        document.getObjectId("_id").toString());
                productos.add(producto);
                System.out.println("document");
            }
        });
        System.out.println("end");
        return productos;
    }

    /**
     * Crea un consumo
     * @param consumo
     * @return
     */
    public boolean crearConsumo(Consumo consumo) {
        MongoCollection col = this.database.getCollection("consumos");
        Document consumoDoc = new Document();
        consumoDoc.append("producto", consumo.getProducto().get_id());
        consumoDoc.append("cantidad", consumo.getCantidad());
        consumoDoc.append("categoria", consumo.getProducto().getCategoria());
        col.insertOne(consumoDoc);
        return true;
    }


    public HashMap<String, Double> getStatsPorCategoria() {
        HashMap<String, Double> stringDoubleHashMap = new HashMap<>();
        // Guardar las categorias
        stringDoubleHashMap.put("Papel-carton", 0.0);
        stringDoubleHashMap.put("Metal", 0.0);
        stringDoubleHashMap.put("Plastico", 0.0);
        stringDoubleHashMap.put("Vidrio", 0.0);
        stringDoubleHashMap.put("Organico", 0.0);

        this.database.getCollection("consumos").find().forEach(new Consumer<Document>() {
            @Override
            public void accept(Document document) {
                if (document.getString("categoria").equals("Papel-carton")) {
                    stringDoubleHashMap.put("Papel-carton", stringDoubleHashMap.get("Papel-carton") + document.getDouble("cantidad"));
                } else if (document.getString("categoria").equals("Plastico")) {
                    stringDoubleHashMap.put("Plastico", stringDoubleHashMap.get("Plastico") + document.getDouble("cantidad"));
                } else if (document.getString("categoria").equals("Metal")) {
                    stringDoubleHashMap.put("Metal", stringDoubleHashMap.get("Metal") + document.getDouble("cantidad"));
                } else if (document.getString("categoria").equals("Vidrio")) {
                    stringDoubleHashMap.put("Vidrio", stringDoubleHashMap.get("Vidrio") + document.getDouble("cantidad"));
                } else if (document.getString("categoria").equals("Organico")) {
                    stringDoubleHashMap.put("Organico", stringDoubleHashMap.get("Organico") + document.getDouble("Organico"));
                }
            }
        });
        return stringDoubleHashMap;
    }
}
