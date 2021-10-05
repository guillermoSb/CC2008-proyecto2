package models;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellido;
    private String departamento;
    private String municipio;
    private int zona;
    private int puntos;
    private ArrayList<Consumo> consumos;
    
    public Usuario(String nombre, String apellido, String departamento, String municipio, int zona, int puntos, ArrayList<Consumo> consumos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.municipio = municipio;
        this.zona = zona;
        this.puntos = puntos;
        this.consumos = consumos;
    }

    public Usuario(String nombre, String apellido, String departamento, String municipio, int zona) {
        this(nombre, apellido, departamento, municipio, zona, 0, new ArrayList<Consumo>());
    }

    public String getApellido() {
        return apellido;
    }

    public ArrayList<Consumo> getConsumos() {
        return consumos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getZona() {
        return zona;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setConsumos(ArrayList<Consumo> consumos) {
        this.consumos = consumos;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        String infoUsuario = "";
        infoUsuario += String.format("%-13s: %s%n", "Nombre", this.getNombre());
        infoUsuario += String.format("%-13s: %s%n", "Apellido", this.getApellido());
        infoUsuario += String.format("%-13s: %s%n", "Departamento", this.getDepartamento());
        infoUsuario += String.format("%-13s: %s%n", "Municipio", this.getMunicipio());
        infoUsuario += String.format("%-13s: %d%n", "Zona", this.getZona());
        infoUsuario += String.format("%-13s: %d%n", "Puntos", this.getPuntos());
        return infoUsuario;
    }
}
