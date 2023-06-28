import { Component } from '@angular/core';
import { Cliente } from '../model/Cliente';
import { ClienteService } from '../service/cliente.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {


  btnCadastro:boolean = true; 


  constructor(private service:ClienteService){}

  clientes:Cliente[]=[];

  selecionar():void{
     this.service.selecionar()
     .subscribe(retorno =>this.clientes = retorno);
  }
}
