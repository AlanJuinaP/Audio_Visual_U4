package uni1a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ContenidoAudiovisual {
    private static int contar = 0;
    private String titulo;
    private int duracionEnMinutos;
    private String genero;
    private int id;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.id = contar++;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

   

    public String toCSV() {
        return id + "," + titulo + "," + duracionEnMinutos + "," + genero;
    }

    public static ContenidoAudiovisual fromCSV(String lineaCSV) {
        // Lógica genérica, las subclases deben implementar su propia conversión.
        return null;
    }

     public static void guardarEnArchivo(String rutaArchivo, List<ContenidoAudiovisual> contenidos) throws IOException {
        List<String> lineas = new ArrayList<>();
        for (ContenidoAudiovisual contenido : contenidos) {
            lineas.add(contenido.toCSV());
        }
        ArchivoUtil.escribirArchivo(rutaArchivo, lineas);
    }
    public static List<ContenidoAudiovisual> leerDesdeArchivo(String rutaArchivo) throws IOException {
        List<String> lineas = ArchivoUtil.leerArchivo(rutaArchivo);
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        for (String linea : lineas) {
            ContenidoAudiovisual contenido = fromCSV(linea);
            if (contenido != null) {
                contenidos.add(contenido);
            }
        }
        return contenidos;
    }
    
    public abstract void mostrarDetalles();
}