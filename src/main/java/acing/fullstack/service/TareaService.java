package acing.fullstack.service;

import acing.fullstack.model.Tarea;
import acing.fullstack.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> getTareas() {
        return tareaRepository.findAll();
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> actualizarTarea(Long id, Tarea tareaActualizada) {
        return tareaRepository.findById(id).map(t -> {
            t.setTitulo(tareaActualizada.getTitulo());
            t.setCompletada(tareaActualizada.isCompletada());
            return tareaRepository.save(t);
        });
    }

    public boolean eliminarTarea(Long id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}