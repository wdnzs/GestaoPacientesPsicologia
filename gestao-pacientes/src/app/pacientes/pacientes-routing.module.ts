import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PacienteComponent } from './containers/paciente/paciente.component';
import { PacienteFormComponent } from './containers/paciente-form/paciente-form.component';
import { PacienteResolver } from './guards/paciente.resolver';

const routes: Routes = [
  { path: '', component: PacienteComponent },
  { path: 'new', component: PacienteFormComponent, resolve: {paciente: PacienteResolver}  },
  { path: 'edit/:id', component: PacienteFormComponent, resolve: {paciente: PacienteResolver} }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PacientesRoutingModule { }
