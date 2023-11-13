package com.diniz.gestaopacientesapi.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diniz.gestaopacientesapi.model.Paciente;
import com.diniz.gestaopacientesapi.repository.PacienteRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/pacientes")
@AllArgsConstructor
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    @GetMapping
    public @ResponseBody List<Paciente> listaPacientes(){
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Paciente> findById(@PathVariable @NotNull @Positive Long id) {
        return pacienteRepository.findById(id)
            .map(item -> ResponseEntity.ok().body(item))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Paciente create(@RequestBody @Valid Paciente paciente) {
       return pacienteRepository.save(paciente);
     }
    
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Paciente paciente){
        return pacienteRepository.findById(id)
            .map((Function<? super Paciente, ? extends ResponseEntity<Paciente>>) item -> {
                item.setNome(paciente.getNome());
                item.setDataNascimento(paciente.getDataNascimento());
                item.setSexo(paciente.getSexo());
                item.setEndereco(paciente.getEndereco());
                item.setBairro(paciente.getBairro());
                item.setCep(paciente.getCep());
                item.setCidade(paciente.getCidade());
                item.setEstado(paciente.getEstado());
                item.setRg(paciente.getRg());
                item.setCpf(paciente.getCpf());
                item.setNomeMae(paciente.getNomeMae());
                item.setNomePai(paciente.getNomePai());
                item.setEstadoCivil(paciente.getEstadoCivil());
                item.setProfissao(paciente.getProfissao());
                item.setNacionalidade(paciente.getNacionalidade());
                item.setCelular(paciente.getCelular());
                item.setTelefone(paciente.getTelefone());
                item.setEmail(paciente.getEmail());

                Paciente updated = pacienteRepository.save(item);
                return ResponseEntity.ok().body(updated);
            }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        return pacienteRepository.findById(id)
        .map((Function<? super Paciente, ? extends ResponseEntity<Void>>) item -> {
            pacienteRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();       
        }).orElseThrow();
    }
    
}
