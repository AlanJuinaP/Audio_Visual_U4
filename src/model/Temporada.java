package model;

public class Temporada {
    private int numero;
    private int cantidadEpisodios;

    public Temporada(int numero, int cantidadEpisodios) {
        this.numero = numero;
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidadEpisodios() {
        return cantidadEpisodios;
    }

    public void setCantidadEpisodios(int cantidadEpisodios) {
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public String toCSV() {
        return numero + ";" + cantidadEpisodios;
    }

    public static Temporada fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(";");
        return new Temporada(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
    }

    public void mostrarDetalles() {
        System.out.println("  Temporada " + numero + ": " + cantidadEpisodios + " episodios.");
    }
}
