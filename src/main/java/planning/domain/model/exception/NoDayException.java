package planning.domain.model.exception;

public class NoDayException extends RuntimeException {
    public NoDayException() {
        super("The day hos not been set.");
    }

    public NoDayException(String message) {
        super(message);
    }
}
