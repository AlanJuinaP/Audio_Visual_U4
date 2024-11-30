package poo;

import java.util.List;

import uni1a.*;


public class PruebaAudioVisual {
	public static void main(String[] args) {
        System.out.println("Prueba de contenido Audiovisual\n");

        //Rutas de los archivos
        String Peliculas_Archivo = "peliculas.cvs";
        String Series_Archivo = "series.cvs";
        String Documentales_Archivo = "documentales.cvs";

        //Leer datos desde los archivos
        List<Pelicula> peliculas = ArchivoUtil.Leer_Peliculas(Peliculas_Archivo);
        List<SerieDeTV> series = ArchivoUtil.Leer_Series(Series_Archivo);
        List<Documental> documentales = ArchivoUtil.Leer_Documentales(Documentales_Archivo);

        //Mostrar datos leidos
        System.out.println("Peliculas: ");
        peliculas.forEach(p -> p.mostrarDetalles());
        System.out.println("Series: ");
        series.forEach(s -> s.mostrarDetalles());
        System.out.println("Documentales: ");
        documentales.forEach(d -> d.mostrarDetalles());

        //modificar datos(opcional) y guardar
        peliculas.add(new Pelicula("Nueva Pelicula", 120, "drama", "Estudio X"));
        ArchivoUtil.Guardar_Peliculas(Peliculas_Archivo, peliculas);
        /* 
         // Crear instancias de las subclases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[3];
        
        //Pelicula con actores
        Pelicula avatar = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
        avatar.Agregar_Actor(new Actor("Sam Worthington", 46));
        avatar.Agregar_Actor(new Actor("Zoe Saldana", 45));
        contenidos[0] = avatar;

        //Serie con Temporadas
        SerieDeTV  F1 = new SerieDeTV("Formula 1", 40, "Anccion", 5);
        F1.Agregar_Temporada(new Temporada(1, 10));
        F1.Agregar_Temporada(new Temporada(2, 10));
        contenidos[1] = F1;

        //Documental con Investigadores
        Documental Alerta_Aero = new Documental("Alerta Aeropuerto", 55, "Investigacion", "Delitos");
        Alerta_Aero.Agregar_Investigador(new Investigador("Neil deGrasse", "Comentarista"));
        Alerta_Aero.Agregar_Investigador(new Investigador("Carl Sagan", "Investigadora"));
        contenidos[2] = Alerta_Aero;
       
        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }*/
    }
}