import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { TareaService } from './services/tarea.service';
import { Tarea } from './models/tarea';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App implements OnInit {

  tareas = signal<Tarea[]>([]);

  form = new FormGroup({
    titulo: new FormControl('', [Validators.required, Validators.minLength(3)]),
    completada: new FormControl(false)
  });

  constructor(private tareaService: TareaService) {}

  ngOnInit(): void {
    this.cargarTareas();
  }

  cargarTareas(): void {
    this.tareaService.getTareas().subscribe({
      next: (data: Tarea[]) => this.tareas.set(data),
      error: (err: unknown) => console.error('Error:', err)
    });
  }

  onSubmit(): void {
    if (this.form.valid) {
      const tarea: Partial<Tarea> = {
        titulo: this.form.value.titulo ?? '',
        completada: this.form.value.completada ?? false
      };
      this.tareaService.crearTarea(tarea).subscribe({
        next: () => {
          this.cargarTareas();
          this.form.reset({ completada: false });
        },
        error: (err: unknown) => console.error('Error:', err)
      });
    }
  }
}
