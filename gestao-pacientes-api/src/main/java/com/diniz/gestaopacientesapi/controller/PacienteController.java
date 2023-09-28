package com.diniz.gestaopacientesapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /**
     * Ao subir a aplicação será gerado um registro contendo os dados
     * passados para o objeto Paciente.
     * Utilizando apenas para fins de teste.
     */
    @Bean
    CommandLineRunner initDatabase(PacienteRepository pacienteRepository){
        return args -> {
            pacienteRepository.deleteAll();

            Paciente paciente = new Paciente();
            paciente.setNome("José");
            paciente.setDataNascimento(new Date("10/10/1974"));
            paciente.setEndereco("Rua sem nome, 10");
            paciente.setBairro("Seila");
            paciente.setCidade("Taubate");
            paciente.setEstado("SP");
            paciente.setEstadoCivil("Solteiro");
            paciente.setNacionalidade("Brasileiro");
            paciente.setNomeMae("Maria");
            

            pacienteRepository.save(paciente);
        };
    }
    
}
