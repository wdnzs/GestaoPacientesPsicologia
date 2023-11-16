package com.diniz.gestaopacientesapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.diniz.gestaopacientesapi.dto.PacienteDTO;
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
    public @ResponseBody List<PacienteDTO> listaPacientes(){
        return pacienteService.listaPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDTO findById(@PathVariable @NotNull @Positive Long id) {
        return pacienteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PacienteDTO create(@RequestBody @Valid @NotNull PacienteDTO paciente) {
       return pacienteService.create(paciente);
     }
    
    @PutMapping("/{id}")
    public PacienteDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull PacienteDTO paciente){
        return pacienteService.update(id, paciente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        pacienteService.delete(id);
    }
    
}
