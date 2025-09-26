package br.com.catalogo.observer;

import br.com.catalogo.model.Media;

/**
 * Interface que define um observador para o catálogo de mídias.
 * Implementações recebem notificação quando uma nova mídia é adicionada.
 */
public interface CatalogObserver {

    /**
     * Chamado quando uma mídia nova é adicionada ao catálogo.
     *
     * @param media mídia adicionada
     */
    void onMediaAdd(Media media);
}
