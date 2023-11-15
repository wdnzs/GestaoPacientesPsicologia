package com.diniz.gestaopacientesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diniz.gestaopacientesapi.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long>{
    
}
