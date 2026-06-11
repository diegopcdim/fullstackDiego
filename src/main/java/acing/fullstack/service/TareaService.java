package acing.fullstack.service;

import acing.fullstack.model.Tarea;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TareaService {

    public List<Tarea> getTareas() {
        return Arrays.asList(
                new Tarea(1L, "Comprar leche", false),
                new Tarea(2L, "Estudiar Spring Boot", true),
                new Tarea(3L, "Hacer ejercicio", false)
        );
    }
}