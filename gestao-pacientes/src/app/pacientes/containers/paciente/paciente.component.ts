import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { Paciente } from '../../model/paciente';
import { PacienteService } from '../../service/paciente.service';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent implements OnInit {

  paciente$: Observable <Paciente[]> | null = null;


  constructor(
    private pacienteService: PacienteService,
    public dialog: MatDialog,
    private router: Router,
    private snackBar: MatSnackBar,
    private route: ActivatedRoute
  ) {
    this.refresh();
 }

 refresh() {
  this.paciente$ = this.pacienteService.list()
    .pipe (
      catchError(error => {
        this.onError('Erro ao carregar pacientes.');
        return of([])
      })
    );
 }

 onError(errorMsg: string) {
  this.dialog.open(ErrorDialogComponent, {
    data: errorMsg
  });
 }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  }

  onAdd(){
    this.router.navigate(['new'], {relativeTo: this.route})
  }

  onEdit(paciente: Paciente) {
    this.router.navigate(['edit', paciente._id], {relativeTo: this.route})
  }

  onDelete(paciente: Paciente) {

    const dialogRef = this.dialog.open(
      ConfirmationDialogComponent, {
        data: 'Tem certeza que deseja remover este paciente?'
      }
    );

    dialogRef.afterClosed().subscribe((result:boolean) => {
      if (result){
        this.pacienteService.delete(paciente._id).subscribe({
          next: () => {
            this.refresh();
            this.snackBar.open('Paciente removido com sucesso!', '', {
              duration: 3000,
              verticalPosition: 'top',
              horizontalPosition: 'center'
            });
          },
          error: () => this.onError('Erro ao tentar remover paciente!')
       });
      }
    });

  }

}
