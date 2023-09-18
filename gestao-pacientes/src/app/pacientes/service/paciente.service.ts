import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Paciente } from '../model/paciente';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  constructor(private httpClient: HttpClient) { }

  list(): Paciente[]{
    return [
      { _id: '1', item: '1', name: 'José' },
      { _id: '2', item: '2', name: 'Maria' }
    ];
  }
}
