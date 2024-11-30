package uni1a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class ArchivoContenidoAudiovisual {
    //metodo generico para leer lineas desde un archivo
    public static List<ContenidoAudiovisual>Leer_Desde_Archivo(String archivo) throws IOException{
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String tipo = datos[0];
            String titulo = datos[1];
            int duracion = Integer.parseInt(datos[2]);
            String genero = datos[3];

            switch (tipo) {
                case "Pelicula":
                    contenidos.add(new Pelicula(titulo, duracion, genero, datos[4]));
                    break;
                case "SerieDeTV":
                    contenidos.add(new SerieDeTV(titulo, duracion, genero, Integer.parseInt(datos[4])));
                    break;
                case "Documental":
                    contenidos.add(new Documental(titulo, duracion, genero, datos[4]));
                    break;
                default:
                    break;
            }
        }
        br.close();
        return contenidos;
    }

    //Metodo oara guardar contenidos en un archivo CSV
    public static void Guardar_Archivo(List<ContenidoAudiovisual> contenidos, String archivo ) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for(ContenidoAudiovisual contenido : contenidos){
            if (contenido instanceof Pelicula) {
                Pelicula pelicula = (Pelicula) contenido;
                bw.write("Pelicula," + pelicula.getTitulo() + "," + pelicula.getDuracionEnMinutos() + "," + pelicula.getGenero() + "," + pelicula.getEstudio());

            }else if (contenido instanceof SerieDeTV) {
                SerieDeTV serie = (SerieDeTV) contenido;
                bw.write("SerieDeTV," + serie.getTitulo() + "," + serie.getDuracionEnMinutos() + "," + serie.getGenero() + "," + serie.getTemporadas());
            }else if (contenido instanceof Documental) {
                Documental documental = (Documental) contenido;
                bw.write("Documental," + documental.getTitulo() + "," + documental.getDuracionEnMinutos() + "," + documental.getGenero() + "," + documental.getTema());
            }
            bw.newLine();
        }
        bw.close();
    }
}
