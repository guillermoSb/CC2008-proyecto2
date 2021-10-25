package views;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.Controller;
import models.CentroReciclaje;
import models.Consumo;
import models.Producto;
import models.Usuario;

public class View {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scan = new Scanner(System.in);

        int opt = 0;
        while (opt != 6) {
            mostrarMenu();
            System.out.print("Ingrese una opcion: ");
            try {
                opt = scan.nextInt();
                // * Validar que exista un usuario para ciertas acciones
                if (controller.getUsuarioActivo() == null && (opt == 2 || opt == 1 || opt == 4)) {
                    mostrarError("Se debe crear un usuario antes de usar esas opciones.");
                }
                // * Evaluar las opciones del menu
                if (opt == 1) {
                    System.out.printf("Categorias disponibles%n0 - Papel-Carton%n1 - Plastico%n2 - Vidrio%n3 - Metal%n");
                    System.out.print("Seleccione una categoria: ");
                    int cat = scan.nextInt();
         
                    // Evaluar si la categoria esta disponible
                    if (cat < 0 || cat > 3) {
                        throw new Exception("Esa categoria no esta disponible"); // Enviar un error
                    }
                    ArrayList<Producto> productos = controller.getProductosPorCategoria(cat);   // Obtener productos
                    if (productos.size() > 0) {
                        for (int i = 0; i < productos.size(); i++) {
                            Producto producto = productos.get(i);
                            System.out.printf("%d - %s - %fkg%n", i, producto.getNombre(), producto.getPesoUnitario());
                        }
                        System.out.print("Ingrese el producto: ");
                        int producto = scan.nextInt();
                        if (producto < 0 || producto > productos.size()) {
                            throw new Exception("El producto seleccionado no existe");
                        }
                        System.out.println("Ingrese los datos del consumo:");   
                        System.out.print("Cantidad de unidades: ");
                        int cantidad = scan.nextInt();
                        mostrarInfo("Creando consumo");
                        controller.crearConsumo(producto, cantidad);
                        mostrarInfo("El consumo se ha guardado");
                    } else {
                        mostrarInfo("No hay productos en esta categoria aun");
                    }
                } else if (opt == 2) {
                    System.out.println("Estadisticas del mes");
                    System.out.printf("%-13s: %d%% %n", "Papel-Carton", 50);
                    System.out.printf("%-13s: %d%% %n", "Plastico", 30);
                    System.out.printf("%-13s: %d%% %n", "Vidrio", 10);
                    System.out.printf("%-13s: %d%% %n", "Metal", 10);
                    // System.out.printf("%-10s: %d\%%n", "Papel-Carton", 50);
                } else if (opt == 3) {
                    System.out.println("Centros de reciclaje abiertos");
                    //System.out.println(controller.MostrarCentros(ArrayList<CentroReciclaje> centrosReciclaje));
                    ArrayList<CentroReciclaje> centros = controller.getCentrosReciclaje();
                    
                    for (CentroReciclaje CentroReciclaje: centros){
                        CentroReciclaje.toString();
                        /*
                        System.out.println("Nombre del Centro: " + CentroReciclaje.getNombre());
                        System.out.println("Departamento: " + CentroReciclaje.getDepartamento());
                        System.out.println("Municipio: " + CentroReciclaje.getMunicipio());
                        System.out.println("Horario de Atención: " + CentroReciclaje.getHorario());
                        */
                    }
                    
                } else if (opt == 4){
                    System.out.println("Dejaste basura en un Centro de Reciclaje");
                    Usuario U = controller.getUsuarioActivo();
                    //ArrayList<Consumo> consumos = U.getConsumos();
                    ArrayList<Producto> productos = controller.getProductos();

                    for (Consumo Consumo: consumos){
                        if (Consumo.getCategoria() == "Papel-Carton"){
                            U.setPuntos(U.getPuntos() + (Consumo.getPesoUnitario() * (5)));
                        } 
                        
                        if (Consumo.getCategoria() == "plastico"){
                            U.setPuntos(U.getPuntos() + (Consumo.getPesoUnitario() * (10)));
                        }

                        if (Consumo.getCategoria() == "vidrio"){
                            U.setPuntos(U.getPuntos() + (Consumo.getPesoUnitario() * (15)));
                        }

                        if (Consumo.getCategoria() == "metal"){
                            U.setPuntos(U.getPuntos() + (Consumo.getPesoUnitario() * (20)));
                        }

                        System.out.println("has acumulado: " + U.getPuntos());
                    }

                    /*
                    for (Producto Producto: productos){
                        if (Producto.getCategoria() == "Papel-Carton"){
                            U.setPuntos(U.getPuntos() + (Producto.getPesoUnitario() * (5)));
                        } 
                        
                        if (Producto.getCategoria() == "plastico"){
                            U.setPuntos(U.getPuntos() + (Producto.getPesoUnitario() * (10)));
                        }

                        if (Producto.getCategoria() == "vidrio"){
                            U.setPuntos(U.getPuntos() + (Producto.getPesoUnitario() * (15)));
                        }

                        if (Producto.getCategoria() == "metal"){
                            U.setPuntos(U.getPuntos() + (Producto.getPesoUnitario() * (20)));
                        }

                        System.out.println("has acumulado: " + U.getPuntos());
                    }
                    */
                    
                
                } else if (opt == 5) {
                    System.out.println("Perfil");
                    System.out.println(controller.getUsuarioActivo());
                } else if (opt == 6) {
                    
                    
                }  else if (opt == 7) {
                    mostrarInfo("Guardando Cambios. Hasta Pronto :D");
                    
                    
                } 
                
            } catch (InputMismatchException e) {
                mostrarError("El valor ingresado no es correcto.");
                scan.nextLine();
            } catch (Exception e) {
                mostrarError(e.getMessage());
            }
        }
        
        scan.close();
    }
    
    public static void mostrarMenu() {
        System.out.println("-.-.-.-.-.-.-.-.-.-.- MENU -.-.-.-.-.-.-.-.-.-.-");
        System.out.println("1 - Ingresar Consumo");
        System.out.println("2 - Obtener estadisticas del mes");
        System.out.println("3 - Informacion Centros de reciclaje");
        System.out.println("4 - Depositar Basura en Centros");
        System.out.println("5 - Ver perfil");
        System.out.println("6 - Crear un nuevo usuario");
        System.out.println("7 - Salir del programa");
    }

    public static void mostrarInfo(String info) {
        System.out.printf("[INFO] %s%n", info);
    }

    public static void mostrarError(String error) {
        System.out.printf("[ERROR] %s%n", error);
    }
}
