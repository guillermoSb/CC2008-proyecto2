package controllers;
import java.util.ArrayList;

import models.CentroReciclaje;
import models.Consumo;
import models.Producto;
import models.Usuario;

import utils.FileManager;

public class Controller {
    private Usuario usuario;
    private ArrayList<Producto> productos;
    private ArrayList<CentroReciclaje> centrosReciclaje;

    public Controller() {
        this.usuario = new Usuario("Guillermo", "Santos", "Guatemala", "Guatemala", 10);
        this.productos = FileManager.cargarProductos();
        this.productos.add( new Producto("papel-carton", 0.65, "Caja de Cereal") );
        this.productos.add( new Producto("plastico", 0.0087, "Botella de plastico") );
        this.productos.add( new Producto("vidrio", 0.245, "Botella de vidrio Coca Cola") );
        this.centrosReciclaje = FileManager.cargarCentroReciclaje();
    }
    
    /**
     * Obtener 
     * @param indexCategoria
     * @return
     */
    public ArrayList<Producto> getProductosPorCategoria(int indexCategoria) {
        String categoriaSeleccionada = Consumo.categoriasDisponibles[indexCategoria];
        ArrayList<Producto> productosClon = (ArrayList<Producto>) this.productos.clone();
        productosClon.removeIf(producto -> !producto.getCategoria().equals(categoriaSeleccionada));
        return productosClon;
    }
    
    public void crearConsumo(int indexProducto, int cantidad) {
        Producto producto = this.productos.get(indexProducto);
        Consumo consumo = new Consumo(producto, cantidad);
        this.usuario.getConsumos().add(consumo);    // Agregar el consumo
    }
    
    public Usuario getUsuarioActivo() {
        return this.usuario;
    }
}
