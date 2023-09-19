import { Component, OnInit } from '@angular/core';

import { PacienteService } from './../service/paciente.service';
import { Observable } from 'rxjs';
import { Paciente } from '../model/paciente';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent implements OnInit {

  paciente$: Observable <Paciente[]>;
  displayedColumns = ['item', 'name']

  constructor(private PacienteService: PacienteService){
    this.paciente$ = this.PacienteService.list();
 }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  }

}
