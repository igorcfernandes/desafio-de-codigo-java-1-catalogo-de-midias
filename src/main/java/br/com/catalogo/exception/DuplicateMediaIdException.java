package br.com.catalogo.exception;

/**
 * Exceção lançada ao tentar adicionar uma mídia com ID duplicado ao catálogo.
 */
public class DuplicateMediaIdException extends Exception {

    /**
     * Construtor da exceção.
     *
     * @param message mensagem explicativa
     */
    public DuplicateMediaIdException(String message) {
        super(message);
    }
}
