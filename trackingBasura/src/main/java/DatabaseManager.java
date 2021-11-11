import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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

        Document doc = new Document("_id", "2").append("name", "john");

        col.insertOne(doc);
    }
}
