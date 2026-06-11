package acing.fullstack.controller;

import acing.fullstack.model.Tarea;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @GetMapping
    public List<Tarea> getTareas() {
        return Arrays.asList(
                new Tarea(1L, "Comprar leche", false),
                new Tarea(2L, "Estudiar Spring Boot", true),
                new Tarea(3L, "Hacer ejercicio", false)
        );
    }
}