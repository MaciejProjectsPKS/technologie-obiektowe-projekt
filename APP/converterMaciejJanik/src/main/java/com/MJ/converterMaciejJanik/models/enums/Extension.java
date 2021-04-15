package com.MJ.converterMaciejJanik.models.enums;

import java.util.Arrays;

public enum Extension {

    JSON("json"),
    XML("xml"),
    YML("yml"),
    INVALID("invalid");


    Extension(String code) {
        this.code =code;
    }
    private final String code;


    public static Extension fromString(String value){
        return Arrays.stream(Extension.values()).filter(s -> s.code.equalsIgnoreCase(value)).findFirst()
                .orElse(Extension.INVALID);
    }

    @Override
    public String toString() {
        return code;
    }
}
