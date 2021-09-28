package com.booking.certificacion.utils;

public enum Messages {

    WRONG_BOOKING_PRICE("Error => El precio obtenido no fue el esperado"),
    PRICE_FILTER_FAILED("Error => Los precios obtenidos por el filtro no se encuetran dentro del rango"),
    STARS_FILTER_FAILED("Error => Las estrellas obtenidos por el filtro no se encuetran dentro del rango"),
    WRONG_ATTRACTION_PRICE("Error => El precio obtenido no fue el esperado");


    private String msg;

    Messages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
