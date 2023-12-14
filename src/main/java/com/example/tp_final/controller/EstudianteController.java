package com.example.tp_final.controller;

import com.example.tp_final.model.Estudiante;
import com.example.tp_final.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping ("ver/estudiantes")
    public List<Estudiante> listarEstudiantes() {
        return estudianteService.verEstudiantes();
    }

    @GetMapping("/{id}")
    public Estudiante buscarEstudiante (@PathVariable int id) {
            Estudiante estudiante = estudianteService.buscarEstudiante(id);
            return estudiante;
    }

    @PostMapping("/new/estudiante")
    public void crearEstudiante(@RequestBody Estudiante estudiante) {
            estudianteService.crearEstudiante(estudiante);
    }

    @PutMapping("/modificar/{id}")
    public void modificarEstudiante (@PathVariable int id, @RequestBody Estudiante estudiante) {
            Estudiante existsEstudiante = estudianteService.buscarEstudiante(id);
            if(!existsEstudiante.equals(null)){
                existsEstudiante.setNombre(estudiante.getNombre());
                existsEstudiante.setApellido(estudiante.getApellido());
                existsEstudiante.setEmail(estudiante.getEmail());
                estudianteService.crearEstudiante(existsEstudiante);
            }
    }

    @DeleteMapping("/delete/{id}")
    public void borrarEstudiante(@PathVariable int id) {
        estudianteService.borrarEstudiante(id);
    }
}
