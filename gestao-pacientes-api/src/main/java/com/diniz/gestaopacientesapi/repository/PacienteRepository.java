package com.diniz.gestaopacientesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diniz.gestaopacientesapi.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long>{
    
}
