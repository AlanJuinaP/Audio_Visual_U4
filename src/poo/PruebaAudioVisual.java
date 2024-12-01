package poo;

import uni1a.*;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        System.out.println("Prueba de contenido audiovisual con clases relacionadas\n");

        // Crear instancias de las subclases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[3];

        Pelicula avatar = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
        avatar.agregarActor(new Actor("Sam Worthington", 46));
        avatar.agregarActor(new Actor("Zoe Saldana", 45));
        contenidos[0] = avatar;

        SerieDeTV got = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);
        got.agregarTemporada(new Temporada(1, 10));
        got.agregarTemporada(new Temporada(2, 10));
        contenidos[1] = got;

        Documental cosmos = new Documental("Cosmos", 45, "Science", "Astronomy");
        cosmos.agregarInvestigador(new Investigador("Neil deGrasse Tyson", "Astrofísica"));
        cosmos.agregarInvestigador(new Investigador("Carl Sagan", "Cosmología"));
        contenidos[2] = cosmos;

        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }

        // Guardar contenidos en un archivo CSV
        guardarEnArchivoCSV("contenidos.csv", contenidos);
    }

    // Método para guardar contenidos en un archivo CSV
    public static void guardarEnArchivoCSV(String nombreArchivo, ContenidoAudiovisual[] contenidos) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (ContenidoAudiovisual contenido : contenidos) {
                writer.write(contenido.toCSV() + "\n");
            }
            System.out.println("Datos guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}