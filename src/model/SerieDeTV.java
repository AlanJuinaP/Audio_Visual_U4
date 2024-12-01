package model;

import java.util.ArrayList;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual {
    private List<Temporada> temporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        this.temporadas.add(temporada);
    }

    @Override
    public String toCSV() {
        StringBuilder temporadasCSV = new StringBuilder();
        for (Temporada temporada : temporadas) {
            temporadasCSV.append(temporada.toCSV()).append("|");
        }
        return super.toCSV() + "," + temporadasCSV;
    }

    public static SerieDeTV fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",");
        SerieDeTV serie = new SerieDeTV(partes[1], Integer.parseInt(partes[2]), partes[3]);
        if (partes.length > 4 && !partes[4].isEmpty()) {
            String[] temporadasPartes = partes[4].split("\\|");
            for (String temporadaData : temporadasPartes) {
                serie.agregarTemporada(Temporada.fromCSV(temporadaData));
            }
        }
        return serie;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas:");
        for (Temporada temporada : temporadas) {
            temporada.mostrarDetalles();
        }
        System.out.println();
    }
}
