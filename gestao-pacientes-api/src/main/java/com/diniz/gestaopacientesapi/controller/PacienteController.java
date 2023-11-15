package com.diniz.gestaopacientesapi.controller;

import java.util.List;
import java.util.Optional;

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
import com.diniz.gestaopacientesapi.service.PacienteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public @ResponseBody List<Paciente> listaPacientes(){
        return pacienteService.listaPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Paciente> findById(@PathVariable @NotNull @Positive Long id) {
        return pacienteService.findById(id)
            .map(item -> ResponseEntity.ok().body(item))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Paciente create(@RequestBody @Valid Paciente paciente) {
       return pacienteService.create(paciente);
     }
    
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Paciente paciente){
        return ((Optional<Paciente>) pacienteService.update(id, paciente))
            .map( item -> {
                return ResponseEntity.ok().body(item);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        if(pacienteService.delete(id)){
            return ResponseEntity.noContent().<Void>build();
        }
        
        return ResponseEntity.notFound().build();
    }
    
}
