package com.diniz.gestaopacientesapi.enums;

public enum Profissao {
    
    DESENVOLVEDOR_DE_SOFTWARE ("Desenvolvedor(a) de Software"),
    PSICOLOGO ("Psicólogo(a)"),
    ADVOGADO ("Advogado(a)"),
    MEDICO ("Médico(a)"),
    ENGENHEIRO ("Engenheiro(a)");

    private String value;

    private Profissao(String value) {
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
