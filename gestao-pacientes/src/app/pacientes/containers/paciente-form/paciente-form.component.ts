import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { PacienteService } from '../../service/paciente.service';

@Component({
  selector: 'app-paciente-form',
  templateUrl: './paciente-form.component.html',
  styleUrls: ['./paciente-form.component.scss']
})
export class PacienteFormComponent implements OnInit{

    form = this.formBuilder.group( {
      nome: [''],
      dataNascimento: [null],
      endereco: [''],
      bairro: [''],
      cep: [''],
      cidade: [''],
      estado: [''],
      rg: [''],
      cpf: [''],
      nomeMae: [''],
      nomePai: [''],
      estadoCivil: [''],
      profissao: [''],
      nacionalidade: ['']
    });

    constructor(private formBuilder: UntypedFormBuilder,
      private service: PacienteService,
      private snackBar: MatSnackBar,
      private location: Location) {
    }

  ngOnInit(): void {
    // document why this method 'ngOnInit' is empty
  }

    onSubmit(){
      this.service.save(this.form.value).subscribe(result => this.onSuccess(), error => this.onError());
    }

    onCancel(){
      this.location.back();
    }

    private onSuccess(){
      this.snackBar.open('Paciente salvo com sucesso!', '', { duration: 2000 });
      this.onCancel();
    }

    private onError(){
      this.snackBar.open('Erro ao salvar paciente.', '', { duration: 2000 })
    }

}
