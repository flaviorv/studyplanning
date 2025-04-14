package planning.domain.model.exception;

public class EndBeforeStartException extends RuntimeException {
    public EndBeforeStartException(String message) {
        super(message);
    }
}
