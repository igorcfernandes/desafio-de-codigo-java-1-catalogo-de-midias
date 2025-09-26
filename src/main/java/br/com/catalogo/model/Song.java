package br.com.catalogo.model;

/**
 * Representa uma música, que é um tipo de mídia.
 */
public class Song extends Media {

    private String artist;
    private String album;

    /**
     * Construtor da música.
     *
     * @param mediaId identificador único da música
     * @param title título da música
     * @param durationInSeconds duranção em segundos da música
     * @param artist nomedo do artista da música
     * @param album título do álbum da música
     */
    public Song(String mediaId, String title, int durationInSeconds, String artist, String album) {
        super(mediaId, title, durationInSeconds);
        this.artist = artist;
        this.album = album;
    }

    /** Exibe os detalhes da música no console */
    @Override
    public void displayDetails() {
        System.out.println(
                "Song [" + mediaId + "]: " + title +
                "\n  Duration: " + durationInSeconds +
                "\n  Artist: " + artist +
                "\n  Album: " + album
        );
    }
}
