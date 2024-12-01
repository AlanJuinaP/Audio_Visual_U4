package uni1a;

/**
 * Representa una temporada con número y cantidad de episodios.
 */
public class Temporada {
    private int numero;
    private int episodios;

    public Temporada(int numero, int episodios) {
        setNumero(numero);
        setEpisodios(episodios);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número de temporada debe ser mayor a 0.");
        }
        this.numero = numero;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        if (episodios <= 0) {
            throw new IllegalArgumentException("La cantidad de episodios debe ser mayor a 0.");
        }
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Temporada " + numero + " (Episodios: " + episodios + ")";
    }
}