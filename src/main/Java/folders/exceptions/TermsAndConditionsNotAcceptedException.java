package folders.exceptions;

import java.io.Serializable;

public class TermsAndConditionsNotAcceptedException extends RuntimeException implements Serializable {
    private String message;

    public TermsAndConditionsNotAcceptedException(String message) {
        this.message = message;
    }
}
