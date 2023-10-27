import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PacienteComponent } from './containers/paciente/paciente.component';
import { PacienteFormComponent } from './containers/paciente-form/paciente-form.component';

const routes: Routes = [
  { path: '', component: PacienteComponent },
  { path: 'new', component: PacienteFormComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PacientesRoutingModule { }
