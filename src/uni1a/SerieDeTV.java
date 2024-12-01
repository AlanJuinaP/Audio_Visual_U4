package uni1a;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase SerieDeTV que extiende ContenidoAudiovisual, incluye funcionalidad de manejo de archivos.
 */
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private List<Temporada> listaDeTemporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaDeTemporadas = new ArrayList<>();
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public List<Temporada> getListaDeTemporadas() {
        return listaDeTemporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        this.listaDeTemporadas.add(temporada);
    }

    
    @Override
    public String toCSV() {
        StringBuilder temporadasCSV = new StringBuilder();
        for (Temporada temporada : listaDeTemporadas) {
            temporadasCSV.append(temporada.getNumero()).append(";").append(temporada.getEpisodios()).append("|");
        }
        return super.toCSV() + "," + temporadas + "," + temporadasCSV.toString();
    }

  
    public static SerieDeTV fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",");
        SerieDeTV serie = new SerieDeTV(partes[1], Integer.parseInt(partes[2]), partes[3], Integer.parseInt(partes[4]));
        if (partes.length > 5 && !partes[5].isEmpty()) {
            String[] temporadasPartes = partes[5].split("\\|");
            for (String temporadaData : temporadasPartes) {
                String[] temporadaInfo = temporadaData.split(";");
                serie.agregarTemporada(new Temporada(Integer.parseInt(temporadaInfo[0]), Integer.parseInt(temporadaInfo[1])));
            }
        }
        return serie;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración promedio por episodio: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + temporadas);
        System.out.println("Detalles de las temporadas: " + listaDeTemporadas);
        System.out.println();
    }
}