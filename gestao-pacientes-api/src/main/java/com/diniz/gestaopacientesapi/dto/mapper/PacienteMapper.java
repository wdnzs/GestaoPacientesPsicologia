package com.diniz.gestaopacientesapi.dto.mapper;

import org.springframework.stereotype.Component;

import com.diniz.gestaopacientesapi.dto.PacienteDTO;
import com.diniz.gestaopacientesapi.model.Paciente;

@Component
public class PacienteMapper {

    public PacienteDTO toDTO(Paciente paciente){
        
        if(paciente == null){
            return null;
        }

        return new PacienteDTO(paciente.getId(), 
                               paciente.getNome(), 
                               paciente.getDataNascimento(), 
                               paciente.getSexo(), 
                               paciente.getEndereco(), 
                               paciente.getBairro(), 
                               paciente.getCep(), 
                               paciente.getCidade(), 
                               paciente.getEstado(), 
                               paciente.getRg(), 
                               paciente.getCpf(), 
                               paciente.getNomeMae(), 
                               paciente.getNomePai(), 
                               paciente.getEstadoCivil(), 
                               paciente.getProfissao(), 
                               paciente.getNacionalidade(), 
                               paciente.getTelefone(), 
                               paciente.getCelular(), 
                               paciente.getEmail());
    }

    public Paciente toEntity(PacienteDTO pacienteDTO){

        if(pacienteDTO == null){
            return null;
        }

        Paciente paciente = new Paciente();
        
        if(pacienteDTO.id() != null){
            paciente.setId(pacienteDTO.id());
        }

        paciente.setNome(pacienteDTO.nome());
        paciente.setDataNascimento(pacienteDTO.dataNascimento());
        paciente.setSexo(pacienteDTO.sexo());
        paciente.setEndereco(pacienteDTO.endereco());
        paciente.setBairro(pacienteDTO.bairro());
        paciente.setCep(pacienteDTO.cep());
        paciente.setCidade(pacienteDTO.cidade());
        paciente.setEstado(pacienteDTO.estado());
        paciente.setRg(pacienteDTO.rg());
        paciente.setCpf(pacienteDTO.cpf());
        paciente.setNomeMae(pacienteDTO.nomeMae());
        paciente.setNomePai(pacienteDTO.nomePai());
        paciente.setEstadoCivil(pacienteDTO.estadoCivil());
        paciente.setProfissao(pacienteDTO.profissao());
        paciente.setNacionalidade(pacienteDTO.nacionalidade());
        paciente.setTelefone(pacienteDTO.telefone());
        paciente.setCelular(pacienteDTO.celular());
        paciente.setEmail(pacienteDTO.email());
        paciente.setStatus("Ativo");

        return paciente;
    }
    
}
