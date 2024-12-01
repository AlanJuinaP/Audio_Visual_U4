package main;

import controller.ContenidoController;
import view.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView vista = new MenuView();
        ContenidoController controlador = new ContenidoController(vista);

        boolean salir = false;

        while (!salir) {
            vista.mostrarMenuPrincipal();
            int opcion = vista.leerEntradaEntero("");

            switch (opcion) {
                case 1 -> controlador.agregarContenido();
                case 2 -> controlador.mostrarContenido();
                case 3 -> controlador.guardarContenidoEnArchivo("contenido.txt");
                case 4 -> controlador.cargarContenidoDesdeArchivo("contenido.txt");
                case 5 -> {
                    vista.mostrarMensaje("Saliendo del programa...");
                    salir = true;
                }
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        }
    }
}