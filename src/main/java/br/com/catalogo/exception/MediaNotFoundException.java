package br.com.catalogo.exception;

/**
 * Exceção lançada quando uma mídia não é encontrada no catálogo.
 */
public class MediaNotFoundException extends Exception {

    /**
     * Construtor da exceção.
     *
     * @param message mensagem explicativa
     */
    public MediaNotFoundException(String message) {
        super(message);
    }
}
