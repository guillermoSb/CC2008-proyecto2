package models;

public class CentroReciclaje {
    private String nombre;
    private String departamento;
    private String municipio;
    private String zona;
    private String horario;

    public String getDepartamento() {
        return departamento;
    }

    public String getHorario() {
        return horario;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getZona() {
        return zona;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
