package models;

import java.util.Date;
import java.util.List;


public class Consumo {

    // Propiedades
    private Producto producto;
    private double cantidad;
    private Date fecha;
    private String categoria;

    // Métodos
    //Constructor
    public Consumo(Producto producto, double cantidad, String categoria){
        this.producto = producto;   // Guardar el producto
        this.cantidad = cantidad * producto.getPesoUnitario();   // Guardar la cantidad
        this.fecha = new Date();
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
