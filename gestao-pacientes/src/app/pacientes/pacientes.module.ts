import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { PacienteFormComponent } from './paciente-form/paciente-form.component';
import { PacienteComponent } from './paciente/paciente.component';
import { PacientesRoutingModule } from './pacientes-routing.module';
import { PacienteListComponent } from './paciente-list/paciente-list.component';

@NgModule({
  declarations: [
    PacienteComponent,
    PacienteFormComponent,
    PacienteListComponent
  ],
  imports: [
    CommonModule,
    PacientesRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class PacientesModule { }
