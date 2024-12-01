package view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Agregar contenido audiovisual");
        System.out.println("2. Mostrar contenido audiovisual");
        System.out.println("3. Guardar contenido en archivo");
        System.out.println("4. Cargar contenido desde archivo");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarOpcionesContenido() {
        System.out.println("=== Tipo de Contenido ===");
        System.out.println("1. Película");
        System.out.println("2. Documental");
        System.out.println("3. Serie de TV");
        System.out.print("Seleccione una opción: ");
    }

    public String leerEntradaTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntradaEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        int entrada = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return entrada;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
