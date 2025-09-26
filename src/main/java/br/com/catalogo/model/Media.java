package br.com.catalogo.model;

/**
 * Classe abstrata que representa uma mídia genérica.
 * Pode ser um filme, uma música ou outro tipo de mídia.
 */
public abstract class Media {

    protected String mediaId;
    protected String title;
    protected int durationInSeconds;

    /**
     * Construtor da mídia.
     *
     * @param mediaId identificador único da mídia
     * @param title título da mídia
     * @param durationInSeconds duração em segundos da mídia
     */
    public Media(String mediaId, String title, int durationInSeconds) {
        this.mediaId = mediaId;
        this.title = title;
        this.durationInSeconds = durationInSeconds;
    }

    /** Exibe os detalhes da mídia no console */
    public abstract void displayDetails();

    /** Retorna o ID da mídia */
    public String getMediaId() {
        return mediaId;
    }

    /** Retorna o título da mídia */
    public String getTitle() {
        return title;
    }
}
