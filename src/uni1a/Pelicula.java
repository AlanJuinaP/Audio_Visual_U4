/**
 * Class Pelicula
 */
package uni1a;
import java.util.ArrayList;
import java.util.List;;

// Subclase Pelicula que extiende de ContenidoAudiovisual
//Subclase actualizada
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private List<Actor> actores; //Relacion con Actor

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actores=new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public List<Actor> getActores(){
        return actores;
    }

    public void Agregar_Actor(Actor actor){
        this.actores.add(actor);
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