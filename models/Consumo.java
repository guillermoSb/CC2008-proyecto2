package models;

import java.util.Date;

public class Consumo {
    private Producto producto;
    private int cantidad;
    private Date fecha;

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Consumo(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

}
