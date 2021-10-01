package controllers;

import java.util.ArrayList;

import models.CentroReciclaje;
import models.Producto;
import models.Usuario;
import utils.FileManager;

public class Controller {
    private Usuario usuario;
    private ArrayList<Producto> productos;
    private ArrayList<CentroReciclaje> centrosReciclaje;

    public Controller() {
        this.usuario = new Usuario("Guillermo", "Santos", "Guatemala", "Guatemala", 10);
        this.productos = FileManager.cargarProductos();
        this.centrosReciclaje = centrosReciclaje;
    }

    public Usuario getUsuarioActivo() {
        return this.usuario;
    }
}
