package com.projeto.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.backend.model.Cliente;
import com.projeto.backend.repository.ClienteRepositorio;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio repositorio;

    public ClienteService(ClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public ResponseEntity<Cliente> CriarCliente(Cliente cliente) {
        return Optional.ofNullable(repositorio.save(cliente))
                .map(newCliente -> ResponseEntity.status(HttpStatus.CREATED).body(newCliente))
                .orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());

    }

    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = repositorio.findAll();

        return !clientes.isEmpty()
                ? ResponseEntity.status(HttpStatus.OK).body(clientes)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public ResponseEntity<Cliente> AtualizarClienteId(Cliente cliente, Long id) {
        return repositorio.findById(id)
                .map(clienteUpdate -> {
                    clienteUpdate.setNome(cliente.getNome());
                    clienteUpdate.setIdade(cliente.getIdade());
                    clienteUpdate.setEmail(cliente.getEmail());
                    clienteUpdate.setCidade(cliente.getCidade());
                    Cliente updatecliente = repositorio.save(clienteUpdate);
                    return ResponseEntity.status(HttpStatus.OK).body(updatecliente);

                }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());

    }

    public ResponseEntity<Cliente> buscarClienteId(Long id) {
        return repositorio.findById(id)
                .map(cliente -> ResponseEntity.status(HttpStatus.OK).body(cliente))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    public ResponseEntity<?> excluirClienteId(Long id) {
        return repositorio.findById(id)
                .map(clienteDelete -> {
                    repositorio.deleteById(id);
                    return ResponseEntity.status(HttpStatus.OK).build();

                }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    

}
