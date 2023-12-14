package com.example.tp_final.service;

import com.example.tp_final.model.Estudiante;
import com.example.tp_final.repository.IEstudianteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private IEstudianteRepository iEstudianteRepository;
    @Override
    public List<Estudiante> verEstudiantes() {
        return iEstudianteRepository.findAll();
    }

    @Override
    public Estudiante buscarEstudiante(int id) {
            return iEstudianteRepository.findById(id).orElse(null);
    }

    @Override
    public void crearEstudiante(Estudiante estudiante){
            iEstudianteRepository.save(estudiante);
    }

    @Override
    public void borrarEstudiante (int id)  {
        iEstudianteRepository.deleteById(id);
    }

/*    public Estudiante update(int id, Estudiante estudiante) throws Exception {
        Optional<Estudiante> exits = iEstudianteRepository.findById(id);
        try {
            if (exits.isPresent()) {
                Estudiante updatedEstudiante = exits.get();
                updatedEstudiante.setEmail(estudiante.getEmail());
                updatedEstudiante.setNombre(estudiante.getNombre());
                updatedEstudiante.setApellido(estudiante.getApellido());

                return iEstudianteRepository.save(updatedEstudiante);
            } else {
                throw new Exception("El id no existe");
            }
        }  catch (Exception e ){
            throw new Exception("Error al actualizar");
        }
    }*/


}
