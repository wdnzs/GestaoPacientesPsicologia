package com.diniz.gestaopacientesapi.enums;

public enum Status {
    ATIVO("Ativo"),
    INATIVO("Inativo");	

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
