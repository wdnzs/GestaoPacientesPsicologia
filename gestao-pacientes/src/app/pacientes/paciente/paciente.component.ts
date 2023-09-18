import { Component, OnInit } from '@angular/core';

import { Paciente } from '../model/paciente';
import { PacienteService } from './../service/paciente.service';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent implements OnInit {

  paciente: Paciente[] = [];
  displayedColumns = ['item', 'name']

  constructor(private PacienteService: PacienteService){
    this.paciente = this.PacienteService.list();
 }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  }

}
