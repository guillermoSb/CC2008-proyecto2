package models;

public class Producto {
  
  //Propiedades
  private String categoria;
  private int PesoUnitario;
  private String nombre;
  
  //Métodos
  //Constructor
  Producto(){
    
  }
  
  //getters
  public String getCategoria() {
    return categoria;
  }

  public int getPesoUnitario() {
    return PesoUnitario;
  }

  public String getNombre() {
    return nombre;
  }
  
  //setters
  
  public void setCategoria(String _categoria) {
    this.categoria = _categoria;
  }

  public void setPesoUnitario(int _pesoUnitario) {
    PesoUnitario = _pesoUnitario;
  }

  public void setNombre(String _nombre) {
    this.nombre = _nombre;
  }

}
