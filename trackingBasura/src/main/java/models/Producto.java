package models;

public class Producto {
  
  //Propiedades
  private String categoria;
  private double pesoUnitario;
  private String nombre;
  
  //Métodos
  //Constructor
  public Producto(String categoria, double pesoUnitario, String nombre){
    this.categoria = categoria;
    this.pesoUnitario = pesoUnitario;
    this.nombre = nombre;
  }
  
  //getters
  public String getCategoria() {
    return categoria;
  }

  public double getPesoUnitario() {
    return pesoUnitario;
  }

  public String getNombre() {
    return nombre;
  }
  
  //setters
  
  public void setCategoria(String _categoria) {
    this.categoria = _categoria;
  }

  public void setPesoUnitario(double _pesoUnitario) {
    pesoUnitario = _pesoUnitario;
  }

  public void setNombre(String _nombre) {
    this.nombre = _nombre;
  }

}
