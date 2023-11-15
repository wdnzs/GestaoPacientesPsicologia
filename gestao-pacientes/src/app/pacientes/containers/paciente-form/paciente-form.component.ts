import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { PacienteService } from '../../service/paciente.service';
import { Paciente } from '../../model/paciente';

@Component({
  selector: 'app-paciente-form',
  templateUrl: './paciente-form.component.html',
  styleUrls: ['./paciente-form.component.scss']
})
export class PacienteFormComponent implements OnInit{

    form = this.formBuilder.group( {

      _id: [''],

      nome: ['',
      [ Validators.required,
        Validators.minLength(3),
        Validators.maxLength(200)] ],

    dataNascimento: ['',
      [ Validators.required,
        Validators.minLength(8),
        Validators.maxLength(10)] ],

    sexo: ['',
      [ Validators.required,
        Validators.minLength(8),
        Validators.maxLength(10)] ],

    endereco: ['',
      [ Validators.required,
        Validators.minLength(10),
        Validators.maxLength(250)] ],

    bairro: ['',
      [ Validators.required,
        Validators.minLength(10),
        Validators.maxLength(200)] ],

    cep: ['',
      [ Validators.required,
        Validators.minLength(5),
        Validators.maxLength(10)] ],

    cidade: ['',
      [ Validators.required,
        Validators.minLength(5),
        Validators.maxLength(100)] ],

    estado: ['',
      [ Validators.required,
        Validators.minLength(5),
        Validators.maxLength(200)] ],

    rg: [''],

    cpf: [''],

    nomeMae: ['',
      [ Validators.required,
        Validators.minLength(5),
        Validators.maxLength(200)] ],

    nomePai: [''],

    estadoCivil: ['',
      [ Validators.required,
        Validators.minLength(5),
        Validators.maxLength(10)] ],

    profissao: [''],

    nacionalidade: ['',
      [ Validators.required,
        Validators.minLength(5),
        Validators.maxLength(100)] ],

    telefone: [''],

    celular: [''],

    email:['']});

    constructor(private formBuilder: UntypedFormBuilder,
      private service: PacienteService,
      private snackBar: MatSnackBar,
      private location: Location,
      private route: ActivatedRoute) {
    }

  ngOnInit(): void {
    const paciente: Paciente = this.route.snapshot.data['paciente'];
    this.form.setValue ({
      _id: paciente._id,
      nome: paciente.nome,
      dataNascimento: paciente.dataNascimento,
      sexo: paciente.sexo,
      endereco: paciente.endereco,
      bairro: paciente.bairro,
      cep: paciente.cep,
      cidade: paciente.cidade,
      estado: paciente.estado,
      rg: paciente.rg,
      cpf: paciente.cpf,
      nomeMae: paciente.nomeMae,
      nomePai: paciente.nomePai,
      estadoCivil: paciente.estadoCivil,
      profissao: paciente.profissao,
      nacionalidade: paciente.nacionalidade,
      telefone: paciente.telefone,
      celular: paciente.celular,
      email: paciente.email
    });
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

    getErrorMessage(fieldName: string){
      const field = this.form.get(fieldName);

      if(field?.hasError('required')) {
        return 'Campo obrigatório!'
      }

      if(field?.hasError('minlength')) {
        const requiredLength: number = field.errors ? field.errors['minlength']['requiredLength'] : 5;
        return `Tamanho mínimo precisa ser de ${requiredLength} caracteres. `
      }

      if(field?.hasError('maxlength')) {
        const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength'] : 200;
        return `Tamanho máximo excedido de ${requiredLength} caracteres. `
      }

      return 'Campo inválido!';
    }

}
