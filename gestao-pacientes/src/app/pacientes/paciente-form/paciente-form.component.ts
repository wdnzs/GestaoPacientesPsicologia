import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { PacienteService } from '../service/paciente.service';

@Component({
  selector: 'app-paciente-form',
  templateUrl: './paciente-form.component.html',
  styleUrls: ['./paciente-form.component.scss']
})
export class PacienteFormComponent implements OnInit{

    form: FormGroup;

    constructor(private formBuilder: FormBuilder,
      private service: PacienteService,
      private snackBar: MatSnackBar) {
      this.form = this.formBuilder.group( {
        nome: [null],
        dataNascimento: [null],
        endereco: [null],
        bairro: [null],
        cep: [null],
        cidade: [null],
        estado: [null],
        rg: [null],
        cpf: [null],
        nomeMae: [null],
        nomePai: [null],
        estadoCivil: [null],
        profissao: [null],
        nacionalidade: [null]
      })
    }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

    onSubmit(){
      this.service.save(this.form.value).subscribe(result => console.log(result), error => this.onError());
    }

    private onError(){
      this.snackBar.open('Erro ao salvar paciente.', '', { duration: 2000 })
    }

}
