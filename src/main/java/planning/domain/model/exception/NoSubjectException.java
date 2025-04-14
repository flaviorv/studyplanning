package planning.domain.model.exception;

public class NoSubjectException extends RuntimeException {
    public NoSubjectException() {
        super("No subject found.");
    }

    public NoSubjectException(String message) {
        super(message);
    }
}
