package uni1a;
import java.io.*;
import java.util.*;

public class ArchivoUtil {

    //leer peliulas desde un archivo CVS
    public static List<Pelicula> Leer_Peliculas(String ruta_Archivo){
        List<Pelicula> peliculas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta_Archivo))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                int duracion = Integer.parseInt(datos[1]);
                String genero = datos[2];
                String estudio = datos[3];
                Pelicula pelicula = new Pelicula(titulo, duracion, genero, estudio);
                peliculas.add(pelicula);
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return peliculas;
    }

    //metodo para gurdar datos de peliculas
    public static void Guardar_Peliculas(String ruta_Archivo, List<Pelicula> peliculas){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta_Archivo))){
            for(Pelicula pelicula : peliculas){
                String linea = String.format("%s,%d,%s,%s", pelicula.getTitulo(),pelicula.getDuracionEnMinutos(),
                    pelicula.getGenero(),pelicula.getEstudio());
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    //Leer series de TV
    public static List<SerieDeTV> Leer_Series(String ruta_Archivo){
        List<SerieDeTV> series = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta_Archivo))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                int duracion = Integer.parseInt(datos[1]);
                String genero = datos[2];
                int temporadas = Integer.parseInt(datos[3]);
                SerieDeTV serie = new SerieDeTV(titulo, duracion, genero, temporadas);
                series.add(serie);
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return series;
    }

    //Guardar series de Tv
    public static void Guardar_Series(String ruta_Archivo, List<SerieDeTV> series){
        try (BufferedWriter bw = new BufferedWriter((new FileWriter(ruta_Archivo)))){
            for(SerieDeTV serie : series){
                String linea = String.format("%s,%d,%s,%s", serie.getTitulo(),serie.getDuracionEnMinutos(),
                    serie.getGenero(), serie.getTemporadas());
                bw.write(linea);
                bw.newLine();
            }            
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }        
    }    

    //Leer documentales
    public static List<Documental> Leer_Documentales(String ruta_Archivo){
        List<Documental> documentales = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta_Archivo))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                int duracion = Integer.parseInt(datos[1]);
                String genero = datos[2];
                String tema = datos[3];
                Documental documental = new Documental(titulo, duracion, genero, tema);
                documentales.add(documental);
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return documentales;
    }
    //Guardar datoa Documentales
    public static void Guardar_Documentales(String ruta_Archivo, List<Documental> documentales){
        try (BufferedWriter bw = new BufferedWriter((new FileWriter(ruta_Archivo)))){
            for(Documental documental : documentales){
                String linea = String.format("%s,%d,%s,%s", documental.getTitulo(),documental.getDuracionEnMinutos(),
                        documental.getGenero(), documental.getTema());
                bw.write(linea);
                bw.newLine();
            }           
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
