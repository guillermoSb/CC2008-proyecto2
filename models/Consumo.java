package models;

import java.util.List;

public class Consumo {

    //Propiedades
    private Producto producto;
    private int cantidad;
    private String fecha;

    //Métodos
    //Constructor
    Consumo(){
        
    }

    //getter
    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    //setter
    public void setProducto(Producto _producto) {
        this.producto = _producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(String _fecha) {
        this.fecha = _fecha;
    }

    public static String[] categoriasDisponibles = {"plastico", "papel-carton", "aluminio", "vidrio"};
    
}
