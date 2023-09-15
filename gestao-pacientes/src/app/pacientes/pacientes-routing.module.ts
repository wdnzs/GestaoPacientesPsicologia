import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PacienteComponent } from './paciente/paciente.component';

const routes: Routes = [
  { path: '', component: PacienteComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PacientesRoutingModule { }
