package br.com.catalogo.service;

import br.com.catalogo.exception.DuplicateMediaIdException;
import br.com.catalogo.exception.MediaNotFoundException;
import br.com.catalogo.model.Media;
import br.com.catalogo.model.Movie;
import br.com.catalogo.model.Song;
import br.com.catalogo.observer.CatalogObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Singleton que gerencia o catálogo de mídias.
 * Permite adicionar, consultar e listar mídias, além de notificar observadores.
 */
public class MediaCatalog {

    private static MediaCatalog instance;
    private Map<String, Media> catalog;
    private List<CatalogObserver> observers;

    public MediaCatalog() {
        catalog = new HashMap<>();
        observers = new ArrayList<>();
    }

    /** Retorna a instância única do catálogo (Singleton) */
    public static MediaCatalog getInstance() {
        if (instance == null) {
            instance = new MediaCatalog();
        }

        return instance;
    }

    /** Registra um observador para receber notificações */
    public void registerObserver(CatalogObserver observer) {
        observers.add(observer);
    }

    /** Notifica todos os observadores sobre a nova mídia */
    private void notifyObserves(Media media) {
        for (CatalogObserver observer : observers) {
            observer.onMediaAdd(media);
        }
    }

    /**
     * Adiciona uma nova mídia ao catálogo.
     *
     * @param media mídia a ser adicionada
     * @throws DuplicateMediaIdException se já existir mídia com mesmo ID
     */
    public void addMedia(Media media) throws DuplicateMediaIdException {
        if (catalog.containsKey(media.getMediaId())) {
            throw new DuplicateMediaIdException("Mídia já está existe no catálogo: " + media.getMediaId());
        }

        catalog.put(media.getMediaId(), media);
        System.out.println("[INFO] Nova mídia adicionada: " + media.getMediaId());
        notifyObserves(media);
    }

    /**
     * Adiciona uma mídia ao catálogo a partir de parâmetros simples.
     *
     * @param type tipo da mídia
     * @param mediaId identificador único da mídia
     * @param title título da mídia
     * @param durationInSeconds duração em segundos da mídia
     * @throws DuplicateMediaIdException se já existir mídia com mesmo ID
     */
    public void addMedia(String type, String mediaId, String title, int durationInSeconds) throws DuplicateMediaIdException {
        Media media = null;

        if (type.equalsIgnoreCase("movie")) {
            media = new Movie(mediaId, title, durationInSeconds, "unknown genre", 0, "unknown director");
        } else if (type.equalsIgnoreCase("song")) {
            media = new Song(mediaId, title, durationInSeconds, "unknown artist", "unknown album");
        }

        if (media != null) {
            addMedia(media);
        }
    }

    /**
     * Recupera uma mídia pelo ID.
     *
     * @param mediaId identificador único da mídia
     * @return mídia encontrada
     * @throws MediaNotFoundException se a mídia não existir
     */
    public Media getMedia(String mediaId) throws MediaNotFoundException {
        Media media = catalog.get(mediaId);

        if (media == null) {
            throw new MediaNotFoundException("Mídia não encontrada: " + mediaId);
        }

        return media;
    }

    /** Retorna a lista de todas as mídias do catálogo */
    public List<Media> listMedia() {
        return new ArrayList<>(catalog.values());
    }
}
