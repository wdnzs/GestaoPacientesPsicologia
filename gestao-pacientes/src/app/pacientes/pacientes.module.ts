import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { PacienteComponent } from './paciente/paciente.component';
import { PacientesRoutingModule } from './pacientes-routing.module';
import { AppMaterialModule } from '../shared/app-material/app-material.module';

@NgModule({
  declarations: [
    PacienteComponent
  ],
  imports: [
    CommonModule,
    PacientesRoutingModule,
    AppMaterialModule
  ]
})
export class PacientesModule { }
