import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { Paciente } from '../model/paciente';
import { PacienteService } from './../service/paciente.service';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent implements OnInit {

  paciente$: Observable <Paciente[]>;
  displayedColumns = ['item', 'name']

  constructor(
    private PacienteService: PacienteService,
    public dialog: MatDialog
  ) {
    this.paciente$ = this.PacienteService.list()
      .pipe(
        catchError(error => {
            this.onError('Erro ao carregar pacientes.');
            return of([])
          })
      );
 }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });

  }
}
