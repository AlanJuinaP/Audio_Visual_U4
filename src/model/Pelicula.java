package model;

public class Pelicula extends ContenidoAudiovisual {
    private String director;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String director) {
        super(titulo, duracionEnMinutos, genero);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + director;
    }

    public static Pelicula fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",");
        return new Pelicula(partes[1], Integer.parseInt(partes[2]), partes[3], partes[4]);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Director: " + director);
        System.out.println();
    }
}
