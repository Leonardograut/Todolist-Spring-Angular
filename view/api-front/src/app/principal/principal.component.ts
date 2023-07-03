import { Component } from '@angular/core';
import { Cliente } from '../model/Cliente';
import { ClienteService } from '../servico/cliente.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {


  cliente = new Cliente();


  btnCadastro:boolean = true; 

  
  clientes:Cliente[]=[];


  tabela:boolean =true;


  constructor(private service:ClienteService){}

 

  selecionar():void{
     this.service.selecionar()
     .subscribe(retorno =>  this.clientes = retorno);
  }


cadastrar():void{
  this.service.cadastrar(this.cliente)
  .subscribe(retorno=>{
    
    this.clientes.push(retorno);
  
    this.cliente = new Cliente();

    alert('Cliente Cadastrado com sucesso!')
 
    
  })
}


selecionarCliente(posicao:number):void{

  this.cliente = this.clientes[posicao];

  this.btnCadastro = false;

  this.tabela = false;
}




 editar():void{
  this.service.editar(this.cliente)
  .subscribe(retorno =>{
 

    let posicao = this.clientes.findIndex(obj =>{

      return obj.id == retorno.id;

    });

    this.clientes[posicao] = retorno;
  
    this.cliente = new Cliente();

    this.btnCadastro = true;

    this.tabela = true;

    alert("Cliente alterado com Sucesso");

  })
 }


remover():void{
    this.service.remover(this.cliente.id)
    .subscribe(retorno=>{
      

      let posicao = this.clientes.findIndex(obj=>{
      return obj.id == this.cliente.id;

      })

    

      this.clientes.splice(posicao,1);

     
      this.cliente = new Cliente();


      this.btnCadastro = true;


      this.tabela = true;


      alert("Cliente removido com sucesso! ")





    })
}


cancelar():void{

  this.cliente = new Cliente();

  this.btnCadastro = true;


  this.tabela= true;  

}





  ngOnInit(){
    this.selecionar();  
  }
}
