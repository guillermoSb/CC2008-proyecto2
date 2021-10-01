package utils;
import java.util.ArrayList;

import models.CentroReciclaje;
import models.Producto;
import models.Usuario;

/**
 * Se encarga de manejar la persitencia de datos.
 */
public class FileManager {
    private static String path = "files";  // Path a los archivos que vamos a utilizar
    
    
    public static Usuario cargarUsuario() {
        // TODO: Implement file persistance
        return null;
    }

    public static ArrayList<Producto> cargarProductos() {
        // TODO: Implement file persistance
        ArrayList<Producto> productos = new ArrayList<Producto>();
        return productos;
    }

    public static ArrayList<CentroReciclaje> cargarCentroReciclaje() {
        // TODO: Implement file persistance
        ArrayList<CentroReciclaje> centrosReciclaje = new ArrayList<CentroReciclaje>();
        return centrosReciclaje;
    }
}