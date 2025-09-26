package br.com.catalogo.observer;

import br.com.catalogo.model.Media;

/**
 * Observador que registras logs no console quando uma mídia é adicionada.
 */
public class LoggingObserver implements CatalogObserver {

    @Override
    public void onMediaAdd(Media media) {
        System.out.println("[LOG] Nova mídia adicionada: " + media.getMediaId() + " - " + media.getTitle());
    }
}
