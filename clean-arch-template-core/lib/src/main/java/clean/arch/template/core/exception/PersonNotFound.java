package clean.arch.template.core.exception;

public class PersonNotFound extends RuntimeException {

    public PersonNotFound(final String message) {
        super(message);
    }

}
