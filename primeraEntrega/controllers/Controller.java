/**
 * Clase Usuario: para la gestion de metodos y atributos de cada usuario que use la plataforma
 * Autores: Guillermo Santos, Daniel Estrada, Roberto Rios
 * 
 */
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
        this.centrosReciclaje.add( new CentroReciclaje("Las 3R", "Guatemala", "Guatemala", "De 8:00am a 5:00pm") );
        this.centrosReciclaje.add( new CentroReciclaje("Casa Verde", "Escuintla", "La Democracia", "De 7:00am a 4:00pm") );
        this.centrosReciclaje.add( new CentroReciclaje("Aguas cristalinas", "Izabal", "Puerto Barrios", "De 11:00am a 5:00pm") );
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

    public ArrayList<CentroReciclaje> getCentrosReciclaje() {
        return centrosReciclaje;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public void crearConsumo(int indexProducto, int cantidad) {
        Producto producto = this.productos.get(indexProducto);
        Consumo consumo = new Consumo(producto, cantidad);
        this.usuario.getConsumos().add(consumo);    // Agregar el consumo
    }
    
    public Usuario getUsuarioActivo() {
        return this.usuario;
    }

    
    /*
    public void MostrarCentros(ArrayList<CentroReciclaje> centrosReciclaje){
        for (CentroReciclaje CentroReciclaje: centrosReciclaje){
            System.out.println("Nombre del Centro: " + CentroReciclaje.getNombre());
            System.out.println("Departamento: " + CentroReciclaje.getDepartamento());
            System.out.println("Municipio: " + CentroReciclaje.getMunicipio());
            System.out.println("Departamento " + CentroReciclaje.getDepartamento());
            System.out.println("Horario de Atención: " + CentroReciclaje.getHorario());
        }
    }
    */


}
