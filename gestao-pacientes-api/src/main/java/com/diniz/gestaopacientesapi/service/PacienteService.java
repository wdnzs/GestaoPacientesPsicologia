package com.diniz.gestaopacientesapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diniz.gestaopacientesapi.exception.RecordNotFoundException;
import com.diniz.gestaopacientesapi.model.Paciente;
import com.diniz.gestaopacientesapi.repository.PacienteRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class PacienteService {
    
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public @ResponseBody List<Paciente> listaPacientes(){
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable @NotNull @Positive Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Paciente create(@RequestBody @Valid Paciente paciente) {
       return pacienteRepository.save(paciente);
    }

    public Paciente update(@NotNull @Positive Long id, @Valid Paciente paciente){
        return pacienteRepository.findById(id)
            .map( item -> {
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

                return pacienteRepository.save(item);
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        pacienteRepository.delete(pacienteRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

}
