package br.com.catalogo;

import br.com.catalogo.exception.DuplicateMediaIdException;
import br.com.catalogo.exception.MediaNotFoundException;
import br.com.catalogo.model.Media;
import br.com.catalogo.model.Movie;
import br.com.catalogo.model.Song;
import br.com.catalogo.observer.ApiCallObserver;
import br.com.catalogo.observer.LoggingObserver;
import br.com.catalogo.service.MediaCatalog;

import java.util.List;

/**
 * Classe principal para demonstrar funcionalidades do catálogo de mídias e do padrão Observer.
 */
public class Main {

    public static void main(String[] args) {

        MediaCatalog catalog = MediaCatalog.getInstance();
        catalog.registerObserver(new LoggingObserver());
        catalog.registerObserver(new ApiCallObserver());

        try {
            // Adicionando filmes
            catalog.addMedia(new Movie("M1", "The Imitation Game", 6840, "Biography, Drama", 2010, "Morten Tyldum"));
            catalog.addMedia(new Movie("M2", "Steve Jobs", 7320, "Biography", 2015, "Danny Boyle"));

            // Adicionando músicas
            catalog.addMedia(new Song("S1", "We're With You", 349, "Mike Stern", "Who Let the Cats Out?"));
            catalog.addMedia(new Song("S2", "Darkness At My Door", 320, "The Paper Kites", "At the Roadhouse"));

            // Teste de mídia duplicada
            catalog.addMedia(new Song("S1", "We're With You", 349, "Mike Stern", "Who Let the Cats Out?"));

            // Adicionando via string
            catalog.addMedia("movie", "M3", "The Social Network", 7200);
        } catch(DuplicateMediaIdException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        System.out.println("\n===== Buscar Mídia do Catálogo =====");

        try {
            Media media = catalog.getMedia("M1");
            System.out.println();
            media.displayDetails();
        } catch (MediaNotFoundException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        System.out.println("\n===== Listar Mídias do Catálogo =====");

        List<Media> allMedia = catalog.listMedia();

        if (allMedia.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada.");
        } else {
            for (Media media : allMedia) {
                System.out.println();
                media.displayDetails();
            }
        }
    }
}
