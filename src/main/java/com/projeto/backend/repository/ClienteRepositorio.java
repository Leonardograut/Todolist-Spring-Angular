package com.projeto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.backend.model.Cliente;

@Repository
public interface ClienteRepositorio  extends JpaRepository <Cliente , Long>{
    
}
