import { Component, OnInit } from '@angular/core';
import { Paciente } from '../model/paciente';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent implements OnInit {

  paciente: Paciente[] = [
    { _id: '1', item: '1', name: 'José' },
    { _id: '2', item: '2', name: 'Maria' }
  ];
  displayedColumns = ['item', 'name']

  //constructor(){
    //this.paciente = [];
 // }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  }

}
