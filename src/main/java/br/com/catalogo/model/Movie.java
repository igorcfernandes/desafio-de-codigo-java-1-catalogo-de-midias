package br.com.catalogo.model;

/**
 * Representa um filme, que é um tipo de mídia.
 */
public class Movie extends Media {

    private String genre;
    private int year;
    private String director;

    /**
     * Construtor do filme.
     *
     * @param mediaId identificador único do filme
     * @param title título do filme
     * @param durationInSeconds duração em segundos do filme
     * @param genre gênero do filme
     * @param year ano de lançamento do filme
     * @param director nome do diretor do filme
     */
    public Movie(String mediaId, String title, int durationInSeconds, String genre, int year, String director) {
        super(mediaId, title, durationInSeconds);
        this.genre = genre;
        this.year = year;
        this.director = director;
    }

    /** Exibe os detalhes do filme no console */
    @Override
    public void displayDetails() {
        System.out.println(
                "Movie [" + mediaId + "]: " + title +
                "\n  Duration: " + durationInSeconds +
                "\n  Genre: " + genre +
                "\n  Year: " + year +
                "\n  Director: " + director
        );
    }
}
