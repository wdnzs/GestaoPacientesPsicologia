package com.diniz.gestaopacientesapi.exception;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(Long id){
        super("Paciente não encontrado com o ID: " + id);
    }
}
