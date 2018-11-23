
package com.leysoft.util;

public enum Scope {

    READ("read"), WRITE("write");

    private String value;

    private Scope(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
