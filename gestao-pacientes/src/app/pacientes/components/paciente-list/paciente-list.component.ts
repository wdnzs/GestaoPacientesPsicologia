import { Component, EventEmitter, Input, Output } from '@angular/core';

import { Paciente } from '../../model/paciente';

@Component({
  selector: 'app-paciente-list',
  templateUrl: './paciente-list.component.html',
  styleUrls: ['./paciente-list.component.scss']
})
export class PacienteListComponent {

  @Input() paciente: Paciente[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);

  readonly displayedColumns = ['id', 'nome', 'acoes'];


  ngOnInit(): void {
    // document why this method 'ngOnInit' is empty

  }

  onAdd(){
    this.add.emit(true);
  }

  onEdit(paciente:Paciente) {
    this.edit.emit(paciente);
  }

}
