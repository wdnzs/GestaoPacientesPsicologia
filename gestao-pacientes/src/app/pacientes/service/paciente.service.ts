import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Paciente } from '../model/paciente';
import { first } from 'rxjs';

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

  save(record: Paciente){
    if(record._id){
      return this.update(record);
    }
    return this.create(record);
  }

  private create(record: Paciente){
    return this.httpClient.post<Paciente>(this.API, record).pipe(first());
  }

  private update(record: Paciente){
    return this.httpClient.put<Paciente>(`${this.API}/${record._id}`, record).pipe(first());
  }

  public delete(id: string){
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }
}
