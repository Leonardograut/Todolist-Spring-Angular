import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{Observable}from 'rxjs'
import { Cliente } from '../model/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {


  private url:string='http://localhost:8080/clientes/';



  constructor(private http:HttpClient) { }

  selecionar():Observable<Cliente[]>{
    return this.http.get<Cliente[]>(this.url);
  }

  cadastrar(obj:Cliente):Observable<Cliente>{
    return this.http.post<Cliente>(this.url,obj);
  }



  editar(obj:Cliente):Observable<Cliente>{

    const url = `${this.url}${obj.id}`; 

    return this.http.put<Cliente>(url,obj)
  }
  

  remover(id:number):Observable<void>{
    const url = `${this.url}${id}`;
    return this.http.delete<void>(url);
  }




}
