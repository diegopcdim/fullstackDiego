import { TestBed } from '@angular/core/testing';

import { Tarea } from './tarea.service';

describe('Tarea', () => {
  let service: Tarea;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Tarea);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
