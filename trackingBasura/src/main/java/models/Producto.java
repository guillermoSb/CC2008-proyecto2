package models;

/**
* clase enccargada de gestionar cambios y propiedades de cada producto que ingrese el usuario como parte de sus consumos
*/
public class Producto {
  
  //Propiedades
  private String _id;
  private String categoria;
  private double pesoUnitario;
  private String nombre;
  
  //Métodos
  //Constructor
  public Producto(String categoria, double pesoUnitario, String nombre, String _id){
    this.categoria = categoria;
    this.pesoUnitario = pesoUnitario;
    this.nombre = nombre;
    this._id = _id;
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

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  @Override
  public String toString() {
    return this.nombre;
  }
}
