package br.com.catalogo.observer;

import br.com.catalogo.model.Media;

/**
 * Observador que simula chama da API para sistema externo quando uma mídia é adicionada.
 */
public class ApiCallObserver implements CatalogObserver {

    @Override
    public void onMediaAdd(Media media) {
        System.out.println("[API] Enviando dados para sistema externo para mídia: " + media.getMediaId());
    }
}
