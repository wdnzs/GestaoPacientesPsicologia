import { Component, Input } from '@angular/core';
import { Paciente } from '../model/paciente';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-paciente-list',
  templateUrl: './paciente-list.component.html',
  styleUrls: ['./paciente-list.component.scss']
})
export class PacienteListComponent {

  @Input() paciente: Paciente[] = [];

  readonly displayedColumns = ['id', 'nome', 'acoes'];

  constructor(private router: Router,
    private route: ActivatedRoute) {}

  ngOnInit(): void {

  }

  onAdd(){
    this.router.navigate(['new'], {relativeTo: this.route})
  }
}
