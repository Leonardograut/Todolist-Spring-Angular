package com.projeto.backend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.backend.model.Cliente;
import com.projeto.backend.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    

    @Autowired
     private ClienteService clienteService;


     public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
     }



     @PostMapping("/")
     public ResponseEntity<Cliente>CriarCliente(@RequestBody Cliente cliente){
        

        return clienteService.CriarCliente(cliente);
     }

     
     @GetMapping("/")
     public ResponseEntity<List<Cliente>>listarCliente(){
       
        return clienteService.getClientes();
     }
     
     @GetMapping("/{id}")
     public ResponseEntity<Cliente>clienteId(@PathVariable Long id){
        return clienteService.buscarClienteId(id);
     }

     @PutMapping("/{id}")
     public ResponseEntity<Cliente>AtualizarClienteId(@RequestBody Cliente cliente, @PathVariable Long id){
        return clienteService.AtualizarClienteId(cliente, id);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<?>ExcluirCliente(@PathVariable Long id){

        return clienteService.excluirClienteId(id);

     }
}
