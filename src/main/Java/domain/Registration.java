package domain;

import org.joda.time.DateTime;

public class Registration {
    private String email;
    private String password;
    private String confirmPassword;
    private int termsId;
    private boolean hasAcceptedTerms;
    private DateTime dateTime;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean hasAcceptedTerms() {
        return hasAcceptedTerms;
    }

    public void setAcceptTermsAndConditions(boolean acceptTermsAndConditions) {
        this.hasAcceptedTerms = acceptTermsAndConditions;
    }
}
