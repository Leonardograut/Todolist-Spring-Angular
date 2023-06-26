package com.projeto.backend.model;

import jakarta.persistence.Column;
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
    private Long  id;


    @Column(name="nome" , length = 100,  nullable =  false)
    private String nome;


    @Column(name="idade" , length = 15,  nullable =  false  )
    private int idade;

    @Column(name="email" , length = 100,  nullable =  false , unique = true)
    private String email;


    @Column(name="nome" , length = 100,  nullable =  false  )
    private String cidade;





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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String ciddade) {
        this.cidade = ciddade;
    }


    public Cliente(){


    }

    
    public Cliente(long id, String nome, int idade, String email, String cidade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cidade = cidade;
    }



}
