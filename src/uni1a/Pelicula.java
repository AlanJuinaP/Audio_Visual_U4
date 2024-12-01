package uni1a;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Pelicula que extiende ContenidoAudiovisual, incluye funcionalidad de manejo de archivos.
 */
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private List<Actor> actores;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void agregarActor(Actor actor) {
        this.actores.add(actor);
    }

    
    @Override
    public String toCSV() {
        StringBuilder actoresCSV = new StringBuilder();
        for (Actor actor : actores) {
            actoresCSV.append(actor.getNombre()).append(";").append(actor.getEdad()).append("|");
        }
        return super.toCSV() + "," + estudio + "," + actoresCSV.toString();
    }


    public static Pelicula fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",");
        Pelicula pelicula = new Pelicula(partes[1], Integer.parseInt(partes[2]), partes[3], partes[4]);
        if (partes.length > 5 && !partes[5].isEmpty()) {
            String[] actoresPartes = partes[5].split("\\|");
            for (String actorData : actoresPartes) {
                String[] actorInfo = actorData.split(";");
                pelicula.agregarActor(new Actor(actorInfo[0], Integer.parseInt(actorInfo[1])));
            }
        }
        return pelicula;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        System.out.println("Actores: " + actores);
        System.out.println();
    }
}