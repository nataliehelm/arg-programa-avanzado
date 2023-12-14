package com.example.tp_final.controller;

import com.example.tp_final.model.Estudiante;
import com.example.tp_final.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class Controlador {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public String principal(Model model) {
        List<Estudiante> listaEstudiantes = estudianteService.verEstudiantes();
        model.addAttribute("estudiantes", listaEstudiantes);
        return "listadoEstudiantes";
    }

    @GetMapping("/agregarEstudiante")
    public String agregarEstudianteForm(Model model) {
        model.addAttribute("nuevoEstudiante", new Estudiante());
        return "agregarEstudiante";
    }

    @PostMapping("/guardarEstudianteNuevo")
    public String agregarEstudiante(@ModelAttribute("nuevoEstudiante") Estudiante newEstudiante) {
        estudianteService.crearEstudiante(newEstudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("modificarEstudiante/{id}")
    public String modificarEstudiante(@PathVariable int id, Model model) {
        Estudiante estudiante = estudianteService.buscarEstudiante(id);
        model.addAttribute("estudiante", estudiante);
        return "modificarEstudiante";
    }

    @PostMapping("/guardarModificacionEstudiante")
    public String guardarModificacionEstudiante(@ModelAttribute Estudiante estudiante){
        estudianteService.crearEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/borrar/{id}")
    public String borrarEstudiante (@PathVariable int id){
        estudianteService.borrarEstudiante(id);
        return "redirect:/estudiantes";
    }

}
