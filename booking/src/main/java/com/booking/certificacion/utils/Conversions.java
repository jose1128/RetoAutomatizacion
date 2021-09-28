package com.booking.certificacion.utils;

public class Conversions {

    private Conversions() {
    }

    public static int stringToInt(String value) {
        return Integer.parseInt(value);
    }

    public static String intToString(int value) {
        return String.valueOf(value);
    }

    public static String replaceCharacters(String value, String newCharacter, String... characters) {
        for (String character : characters) {
            value = value.replace(character, newCharacter);
        }
        return value.trim();
    }
}
