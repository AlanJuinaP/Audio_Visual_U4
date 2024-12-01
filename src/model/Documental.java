package model;

import java.util.ArrayList;
import java.util.List;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private List<Investigador> investigadores;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void agregarInvestigador(Investigador investigador) {
        this.investigadores.add(investigador);
    }

    @Override
    public String toCSV() {
        StringBuilder investigadoresCSV = new StringBuilder();
        for (Investigador investigador : investigadores) {
            investigadoresCSV.append(investigador.getNombre())
                             .append(";")
                             .append(investigador.getEspecialidad())
                             .append("|");
        }
        return super.toCSV() + "," + tema + "," + investigadoresCSV;
    }

    public static Documental fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",");
        Documental documental = new Documental(partes[1], Integer.parseInt(partes[2]), partes[3], partes[4]);
        if (partes.length > 5 && !partes[5].isEmpty()) {
            String[] investigadoresPartes = partes[5].split("\\|");
            for (String investigadorData : investigadoresPartes) {
                String[] investigadorInfo = investigadorData.split(";");
                documental.agregarInvestigador(new Investigador(investigadorInfo[0], investigadorInfo[1]));
            }
        }
        return documental;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + tema);
        System.out.println("Investigadores: " + investigadores);
        System.out.println();
    }
}
