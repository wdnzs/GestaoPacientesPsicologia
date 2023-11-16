package com.diniz.gestaopacientesapi.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDTO(
    @JsonProperty("_id") Long id,
    @NotBlank @NotNull @Length(min = 5, max = 200) String nome,
    @NotBlank @NotNull String dataNascimento,
    @NotBlank @NotNull @Pattern(regexp = "Masculino|Feminino") String sexo,
    @NotBlank @NotNull String endereco,
    @NotBlank @NotNull String bairro,
    String cep,
    @NotBlank @NotNull String cidade,
    @NotBlank @NotNull String estado,
    String rg,
    String cpf,
    @NotBlank @NotNull String nomeMae,
    String nomePai,
    @NotBlank @NotNull String estadoCivil,
    String profissao,
    @NotBlank @NotNull String nacionalidade,
    String telefone,
    String celular,
    @Email String email) {


}
