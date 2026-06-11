package acing.fullstack.service;

import acing.fullstack.model.Tarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private List<Tarea> tareas = new ArrayList<>();
    private Long contadorId = 1L;

    public TareaService() {
        tareas.add(new Tarea(contadorId++, "Comprar leche", false));
        tareas.add(new Tarea(contadorId++, "Estudiar Spring Boot", true));
        tareas.add(new Tarea(contadorId++, "Hacer ejercicio", false));
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public Tarea crearTarea(Tarea tarea) {
        tarea.setId(contadorId++);
        tareas.add(tarea);
        return tarea;
    }

    public Optional<Tarea> actualizarTarea(Long id, Tarea tareaActualizada) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(t -> {
                    t.setTitulo(tareaActualizada.getTitulo());
                    t.setCompletada(tareaActualizada.isCompletada());
                    return t;
                });
    }

    public boolean eliminarTarea(Long id) {
        return tareas.removeIf(t -> t.getId().equals(id));
    }
}