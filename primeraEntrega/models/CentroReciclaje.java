package models;

public class CentroReciclaje {
    //propiedades
    private String nombre;
    private String departamento;
    private String municipio;
    private int zona;
    private String horario;

    //Métodos

    //Constructor
    public CentroReciclaje(String nombre, String departamento, String municipio, String horario){
        this.nombre = nombre;
        this.departamento = departamento;
        this.municipio = municipio;
        this.horario = horario;
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

    public int getZona() {
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

    public void setZona(int _zona) {
        this.zona = _zona;
    }

    public void setHorario(String _horario) {
        this.horario = _horario;
    }
    
    @Override
    public String toString() {
        String infoCentros = "";
        infoCentros += String.format("%-13s: %s%n", "Nombre", this.getNombre());
        infoCentros += String.format("%-13s: %s%n", "Departamento", this.getDepartamento());
        infoCentros += String.format("%-13s: %s%n", "Municipio", this.getMunicipio());
        infoCentros += String.format("%-13s: %d%n", "Zona", this.getZona());
        infoCentros += String.format("%-13s: %d%n", "Horario de Atención", this.getHorario());
        return infoCentros;
    }
}