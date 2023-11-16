package com.diniz.gestaopacientesapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.diniz.gestaopacientesapi.dto.PacienteDTO;
import com.diniz.gestaopacientesapi.dto.mapper.PacienteMapper;
import com.diniz.gestaopacientesapi.enums.Profissao;
import com.diniz.gestaopacientesapi.exception.RecordNotFoundException;
import com.diniz.gestaopacientesapi.repository.PacienteRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class PacienteService {
    
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper){
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    public List<PacienteDTO> listaPacientes(){
        return pacienteRepository.findAll().stream().map(pacienteMapper::toDTO)
                    .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PacienteDTO findById(@PathVariable @NotNull @Positive Long id) {
        return pacienteRepository.findById(id).map(pacienteMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public PacienteDTO create(@RequestBody @Valid @NotNull PacienteDTO paciente) {
       return pacienteMapper.toDTO(pacienteRepository.save(pacienteMapper.toEntity(paciente)));
    }

    public PacienteDTO update(@NotNull @Positive Long id, @Valid @NotNull PacienteDTO paciente){
        return pacienteRepository.findById(id)
            .map( item -> {
                item.setNome(paciente.nome());
                item.setDataNascimento(paciente.dataNascimento());
                item.setSexo(paciente.sexo());
                item.setEndereco(paciente.endereco());
                item.setBairro(paciente.bairro());
                item.setCep(paciente.cep());
                item.setCidade(paciente.cidade());
                item.setEstado(paciente.estado());
                item.setRg(paciente.rg());
                item.setCpf(paciente.cpf());
                item.setNomeMae(paciente.nomeMae());
                item.setNomePai(paciente.nomePai());
                item.setEstadoCivil(paciente.estadoCivil());
                item.setProfissao(Profissao.ADVOGADO);
                item.setNacionalidade(paciente.nacionalidade());
                item.setCelular(paciente.celular());
                item.setTelefone(paciente.telefone());
                item.setEmail(paciente.email());

                return pacienteRepository.save(item);
            }).map(pacienteMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        pacienteRepository.delete(pacienteRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

}
