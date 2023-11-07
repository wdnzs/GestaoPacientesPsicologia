import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { Paciente } from '../model/paciente';
import { PacienteService } from '../service/paciente.service';

@Injectable({
  providedIn: 'root'
})
export class PacienteResolver implements Resolve<Paciente> {

  constructor(private service: PacienteService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Paciente> {
    if (route.params && route.params['id']) {
      return this.service.loadById(route.params['id']);
    }
    return of({ _id: '',
                nome: '',
                dataNascimento: '',
                sexo: '',
                endereco: '',
                bairro: '',
                cep: '',
                cidade: '',
                estado: '',
                rg: '',
                cpf: '',
                nomeMae: '',
                nomePai: '',
                estadoCivil: '',
                profissao: '',
                nacionalidade: '',
                telefone: '',
                celular: '',
                email: ''
                });
  }
}
