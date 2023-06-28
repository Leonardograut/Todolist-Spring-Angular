import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{Observable}from 'rxjs'
import { Cliente } from '../model/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {


  private url:string='http:/localhost:8080';



  constructor(private http:HttpClient) { }

  selecionar():Observable<Cliente[]>{
    return this.http.get<Cliente[]>(this.url);
  }
}
