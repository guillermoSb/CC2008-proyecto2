package models;

import java.util.Date;
import java.util.List;


public class Consumo {

    // Propiedades
    private Producto producto;
    private double cantidad;
    private Date fecha;

    // Métodos
    //Constructor
    public Consumo(Producto producto, double cantidad){
        this.producto = producto;   // Guardar el producto
        this.cantidad = cantidad * producto.getPesoUnitario();   // Guardar la cantidad
        this.fecha = new Date();
    }

    // getter
    public Producto getProducto() {
        return producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    // setter
    public void setProducto(Producto _producto) {
        this.producto = _producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(Date _fecha) {
        this.fecha = _fecha;
    }

    public static String[] categoriasDisponibles = {"papel-carton", "plastico", "vidrio" , "metal"};
    
}
