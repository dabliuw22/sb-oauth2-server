
package com.leysoft.util;

public enum Concession {

    AUTHORIZATION_CODE("authorization_code"),
    IMPLICIT("implicit"),
    PASSWORD_CREDENTIALS("password"),
    CLIENT_CREDENTIALS("client_credentials"),
    REFRESH_TOKEN("refresh_token");

    private String value;

    private Concession(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
