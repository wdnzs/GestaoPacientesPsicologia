import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-paciente-form',
  templateUrl: './paciente-form.component.html',
  styleUrls: ['./paciente-form.component.scss']
})
export class PacienteFormComponent implements OnInit{

    form: FormGroup;

    constructor(private formBuilder: FormBuilder) {
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

    onSubmit(){

    }

    onCancel(){

    }
}
