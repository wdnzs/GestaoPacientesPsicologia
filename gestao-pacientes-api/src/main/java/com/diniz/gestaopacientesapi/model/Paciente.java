package com.diniz.gestaopacientesapi.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE Paciente SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 200)
    @Column(length = 200, nullable = false)
    private String nome;
    
    @NotBlank
    @NotNull
    @Column(length = 10, nullable = false)
    private String dataNascimento;

    @NotBlank
    @NotNull
    @Pattern(regexp = "Masculino|Feminino")
    @Column(length = 10, nullable = false)
    private String sexo;

    @NotBlank
    @NotNull
    @Column(length = 250, nullable = false)
    private String endereco;

    @NotBlank
    @NotNull
    @Column(length = 200, nullable = false)
    private String bairro;

    @Column(length = 10, nullable = true)
    private String cep;

    @NotBlank
    @NotNull
    @Column(length = 100, nullable = false)
    private String cidade;

    @NotBlank
    @NotNull
    @Column(length = 200, nullable = false)
    private String estado;

    @Column(length = 50, nullable = true)
    private String rg;

    @Column(length = 50, nullable = true)
    private String cpf;

    @NotBlank
    @NotNull
    @Column(length = 200, nullable = false)
    private String nomeMae;

    @Column(length = 200, nullable = true)
    private String nomePai;

    @NotBlank
    @NotNull
    @Column(length = 10, nullable = false)
    private String estadoCivil;

    @Column(length = 200, nullable = true)
    private String profissao;

    @NotBlank
    @NotNull
    @Column(length = 100, nullable = false)
    private String nacionalidade;

    @Column(length = 14, nullable = true)
    private String telefone;

    @Column(length = 15, nullable = true)
    private String celular;

    @Email
    @Column(length = 100, nullable = true)
    private String email;

    @NotBlank
    @Length(min = 5, max = 200)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";

}