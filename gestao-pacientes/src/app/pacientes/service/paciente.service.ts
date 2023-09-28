import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Paciente } from '../model/paciente';
import { delay, first } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  private readonly API = 'api/pacientes';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Paciente[]>(this.API).pipe(
      first(),
      //delay(2000)
      );
  }

  loadById(id: string) {
    return this.httpClient.get<Paciente>(`${this.API}/${id}`);
  }
}
