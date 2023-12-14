package com.example.tp_final.repository;

import com.example.tp_final.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepository extends JpaRepository <Estudiante, Integer> {
}
