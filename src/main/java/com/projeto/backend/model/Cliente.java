package com.projeto.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;



    private String nome;


    private int idade;

    private String email;

    private String ciddade;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiddade() {
        return ciddade;
    }

    public void setCiddade(String ciddade) {
        this.ciddade = ciddade;
    }


    public Cliente(){


    }

    
    public Cliente(long id, String nome, int idade, String email, String ciddade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.ciddade = ciddade;
    }



}
