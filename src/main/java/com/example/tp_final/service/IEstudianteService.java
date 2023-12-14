package com.example.tp_final.service;

import com.example.tp_final.model.Estudiante;

import java.util.List;

public interface IEstudianteService {

    public List<Estudiante> verEstudiantes();
    public void crearEstudiante(Estudiante estudiante);
    public void borrarEstudiante (int id);
    public Estudiante buscarEstudiante (int id);
}
