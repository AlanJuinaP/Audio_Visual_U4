package controller;

import model.*;
import view.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContenidoController {
    private List<ContenidoAudiovisual> contenidos;
    private MenuView vista;

    public ContenidoController(MenuView vista) {
        this.vista = vista;
        this.contenidos = new ArrayList<>();
    }

    public void agregarContenido() {
        vista.mostrarOpcionesContenido();
        int opcion = vista.leerEntradaEntero("Ingrese su elección: ");

        switch (opcion) {
            case 1 -> agregarPelicula();
            case 2 -> agregarDocumental();
            case 3 -> agregarSerie();
            default -> vista.mostrarMensaje("Opción no válida.");
        }
    }

    private void agregarPelicula() {
        String titulo = vista.leerEntradaTexto("Ingrese el título de la película: ");
        int duracion = vista.leerEntradaEntero("Ingrese la duración (en minutos): ");
        String genero = vista.leerEntradaTexto("Ingrese el género: ");
        String director = vista.leerEntradaTexto("Ingrese el director: ");

        contenidos.add(new Pelicula(titulo, duracion, genero, director));
        vista.mostrarMensaje("Película agregada exitosamente.");
    }

    private void agregarDocumental() {
        String titulo = vista.leerEntradaTexto("Ingrese el título del documental: ");
        int duracion = vista.leerEntradaEntero("Ingrese la duración (en minutos): ");
        String genero = vista.leerEntradaTexto("Ingrese el género: ");
        String tema = vista.leerEntradaTexto("Ingrese el tema: ");

        Documental documental = new Documental(titulo, duracion, genero, tema);

        String agregarOtro;
        do {
            String nombreInvestigador = vista.leerEntradaTexto("Ingrese el nombre del investigador: ");
            String especialidad = vista.leerEntradaTexto("Ingrese la especialidad: ");
            documental.agregarInvestigador(new Investigador(nombreInvestigador, especialidad));
            agregarOtro = vista.leerEntradaTexto("¿Desea agregar otro investigador? (s/n): ");
        } while (agregarOtro.equalsIgnoreCase("s"));

        contenidos.add(documental);
        vista.mostrarMensaje("Documental agregado exitosamente.");
    }

    private void agregarSerie() {
        String titulo = vista.leerEntradaTexto("Ingrese el título de la serie: ");
        int duracion = vista.leerEntradaEntero("Ingrese la duración promedio de episodios (en minutos): ");
        String genero = vista.leerEntradaTexto("Ingrese el género: ");

        SerieDeTV serie = new SerieDeTV(titulo, duracion, genero);

        String agregarOtra;
        do {
            int numeroTemporada = vista.leerEntradaEntero("Ingrese el número de la temporada: ");
            int cantidadEpisodios = vista.leerEntradaEntero("Ingrese la cantidad de episodios: ");
            serie.agregarTemporada(new Temporada(numeroTemporada, cantidadEpisodios));
            agregarOtra = vista.leerEntradaTexto("¿Desea agregar otra temporada? (s/n): ");
        } while (agregarOtra.equalsIgnoreCase("s"));

        contenidos.add(serie);
        vista.mostrarMensaje("Serie agregada exitosamente.");
    }

    public void mostrarContenido() {
        if (contenidos.isEmpty()) {
            vista.mostrarMensaje("No hay contenido disponible.");
        } else {
            for (ContenidoAudiovisual contenido : contenidos) {
                contenido.mostrarDetalles();
            }
        }
    }

    public void guardarContenidoEnArchivo(String rutaArchivo) {
        List<String> lineas = new ArrayList<>();
        for (ContenidoAudiovisual contenido : contenidos) {
            lineas.add(contenido.toCSV());
        }
        try {
            ArchivoUtil.escribirArchivo(rutaArchivo, lineas);
            vista.mostrarMensaje("Contenido guardado en archivo exitosamente.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al guardar en archivo: " + e.getMessage());
        }
    }

    public void cargarContenidoDesdeArchivo(String rutaArchivo) {
        try {
            List<String> lineas = ArchivoUtil.leerArchivo(rutaArchivo);
            contenidos.clear();
            for (String linea : lineas) {
                String tipo = linea.split(",")[0];
                switch (tipo) {
                    case "Pelicula" -> contenidos.add(Pelicula.fromCSV(linea));
                    case "Documental" -> contenidos.add(Documental.fromCSV(linea));
                    case "SerieDeTV" -> contenidos.add(SerieDeTV.fromCSV(linea));
                }
            }
            vista.mostrarMensaje("Contenido cargado desde archivo exitosamente.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al cargar archivo: " + e.getMessage());
        }
    }
}
