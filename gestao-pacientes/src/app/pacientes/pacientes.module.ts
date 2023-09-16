import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material/table';

import { PacienteComponent } from './paciente/paciente.component';
import { PacientesRoutingModule } from './pacientes-routing.module';

@NgModule({
  declarations: [
    PacienteComponent
  ],
  imports: [
    CommonModule,
    PacientesRoutingModule,
    MatTableModule
  ]
})
export class PacientesModule { }
