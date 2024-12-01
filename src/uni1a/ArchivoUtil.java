package uni1a;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para manejar la lectura y escritura de archivos.
 */
public class ArchivoUtil {

   
    public static void escribirArchivo(String rutaArchivo, List<String> lineas) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String linea : lineas) {
                escritor.write(linea);
                escritor.newLine();
            }
        }
    }

    
    public static List<String> leerArchivo(String rutaArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }
}