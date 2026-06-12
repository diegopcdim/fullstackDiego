import { Component, OnInit, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App implements OnInit {
  tareas = signal<any[]>([]);

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/tareas').subscribe({
      next: (data) => {
        console.log('Datos recibidos:', data);
        this.tareas.set(data);
      },
      error: (err) => console.error('Error:', err)
    });
  }
}
