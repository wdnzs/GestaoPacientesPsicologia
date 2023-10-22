package com.diniz.gestaopacientesapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diniz.gestaopacientesapi.model.Paciente;
import com.diniz.gestaopacientesapi.repository.PacienteRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pacientes")
@AllArgsConstructor
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    @GetMapping
    public @ResponseBody List<Paciente> listaPacientes(){
        return pacienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Paciente create(@RequestBody Paciente paciente) {
       return pacienteRepository.save(paciente);
     }
    
}
