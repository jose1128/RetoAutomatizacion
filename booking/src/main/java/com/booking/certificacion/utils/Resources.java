package com.booking.certificacion.utils;

public enum Resources {

    BOOKING_URL("https://www.booking.com"),
    COP("COP"),
    CHARACTER_POINT(".");

    private String resource;

    Resources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public Resources setResource(String resource) {
        this.resource = resource;
        return this;
    }
}
