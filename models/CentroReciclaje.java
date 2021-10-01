package models;

public class CentroReciclaje {
    //propiedades
    private String nombre;
    private String departamento;
    private String municipio;
    private String zona;
    private String horario;

    //Métodos

    //Constructor
    CentroReciclaje(){

    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getZona() {
        return zona;
    }

    public String getHorario() {
        return horario;
    }

    //setters
    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }

    public void setDepartamento(String _departamento) {
        this.departamento = _departamento;
    }

    public void setMunicipio(String _municipio) {
        this.municipio = _municipio;
    }

    public void setZona(String _zona) {
        this.zona = _zona;
    }

    public void setHorario(String _horario) {
        this.horario = _horario;
    }
    
}