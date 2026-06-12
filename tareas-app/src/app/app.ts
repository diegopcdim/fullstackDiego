import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TareaService } from './services/tarea.service';
import { Tarea } from './models/tarea';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App implements OnInit {

  tareas = signal<Tarea[]>([]);

  constructor(private tareaService: TareaService) {}

  ngOnInit(): void {
    console.log('ngOnInit ejecutado');
    this.tareaService.getTareas().subscribe({
      next: (data: Tarea[]) => {
        console.log('Tareas recibidas:', data);
        this.tareas.set(data);
      },
      error: (err: unknown) => console.error('Error:', err)
    });
  }
}
