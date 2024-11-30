package uni1a;

import java.util.*;

public class Repositorio_ContenidoAudioVisual {
    private List<ContenidoAudiovisual> contenidos;

    public Repositorio_ContenidoAudioVisual(){
        this.contenidos = new ArrayList<>();
    }

    public void Agregar_Contenido(ContenidoAudiovisual contenido){
        contenidos.add(contenido);
    }

    public List<ContenidoAudiovisual> obtener_Contenidos(){
        return contenidos;
    }

    public List<Pelicula> obtener_Peliculas(){
        List<Pelicula> peliculas = new ArrayList<>();
        for(ContenidoAudiovisual contenido : contenidos){
            if(contenido instanceof Pelicula){
                peliculas.add((Pelicula) contenido);
            }
        }
        return peliculas;
    }

    public List<SerieDeTV> obtener_Series(){
        List<SerieDeTV> series = new ArrayList<>();
        for(ContenidoAudiovisual contenido : contenidos){
            if (contenido instanceof SerieDeTV) {
                series.add((SerieDeTV) contenido);
            }
        }
        return series;
    }

    public List<Documental> obtener_Documentales(){
        List<Documental> documentales = new ArrayList<>();
        for(ContenidoAudiovisual contenido : contenidos){
            if (contenido instanceof Documental) {
                documentales.add((Documental) contenido);
            }
        }
        return documentales;
    }
}
