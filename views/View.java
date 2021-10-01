package views;
import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.Controller;
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
                System.out.println(opt);
                // * Evaluar las opciones del menu
                if (opt == 1) {
                    System.out.printf("Categorias disponibles%n0 - Papel-Carton%n1- Plastico%n2 - Vidrio%n3 - Metal");
                    System.out.print("Seleccione una categoria");
                    int cat = scan.nextInt();
                    System.out.println("Ingrese los datos del consumo:");
                } else if (opt == 2) {
                    System.out.println("Estadisticas del mes");
                    System.out.printf("%-13s: %d%% %n", "Papel-Carton", 50);
                    System.out.printf("%-13s: %d%% %n", "Plastico", 30);
                    System.out.printf("%-13s: %d%% %n", "Vidrio", 10);
                    System.out.printf("%-13s: %d%% %n", "Metal", 10);
                    // System.out.printf("%-10s: %d\%%n", "Papel-Carton", 50);
                } else if (opt == 3) {

                } else if (opt == 4) {
                    mostrarInfoUsuario(controller.getUsuarioActivo());
                } else if (opt == 5) {
                    
                }  else if (opt == 6) {
                    mostrarInfo("Guardando Cambios. Hasta Pronto :D");
                } 
                
            } catch (InputMismatchException e) {
                mostrarError("El valor ingresado no es correcto.");
                scan.nextLine();
            }
        }
        
        scan.close();
    }
    
    public static void mostrarMenu() {
        System.out.println("-.-.-.-.-.-.-.-.-.-.- MENU -.-.-.-.-.-.-.-.-.-.-");
        System.out.println("1 - Ingresar Consumo");
        System.out.println("2 - Obtener estadisticas del mes");
        System.out.println("3 - Informacion Centros de reciclaje");
        System.out.println("4 - Ver perfil");
        System.out.println("5 - Crear un nuevo usuario");
        System.out.println("6 - Salir del programa");
    }

    public static void mostrarInfoUsuario(Usuario usuario) {
        System.out.println("Perfil");
        System.out.printf("%-13s: %s%n", "Nombre", usuario.getNombre());
        System.out.printf("%-13s: %s%n", "Apellido", usuario.getApellido());
        System.out.printf("%-13s: %s%n", "Departamento", usuario.getDepartamento());
        System.out.printf("%-13s: %s%n", "Municipio", usuario.getMunicipio());
        System.out.printf("%-13s: %d%n", "Zona", usuario.getZona());
        System.out.printf("%-13s: %d%n", "Puntos", usuario.getPuntos());
    }


    public static void mostrarInfo(String info) {
        System.out.printf("[INFO] %s%n", info);
    }

    public static void mostrarError(String error) {
        System.out.printf("[ERROR] %s%n", error);
    }
}
