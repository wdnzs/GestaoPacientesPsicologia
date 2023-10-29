package com.diniz.gestaopacientesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 10, nullable = false)
    private String dataNascimento;

    @Column(length = 10, nullable = false)
    private String sexo;

    @Column(length = 250, nullable = false)
    private String endereco;

    @Column(length = 200, nullable = false)
    private String bairro;

    @Column(length = 10, nullable = true)
    private String cep;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 200, nullable = false)
    private String estado;

    @Column(length = 50, nullable = true)
    private String rg;

    @Column(length = 50, nullable = true)
    private String cpf;

    @Column(length = 200, nullable = false)
    private String nomeMae;

    @Column(length = 200, nullable = true)
    private String nomePai;

    @Column(length = 10, nullable = false)
    private String estadoCivil;

    @Column(length = 200, nullable = true)
    private String profissao;

    @Column(length = 100, nullable = false)
    private String nacionalidade;

}