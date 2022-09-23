package exceptions;

public class LegajoInvalidoException extends Exception{
    private int legajo;

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public LegajoInvalidoException(String message, int legajo) {
        super(message);
        this.legajo = legajo;
    }
}
