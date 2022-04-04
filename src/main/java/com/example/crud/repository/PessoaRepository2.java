package com.example.crud.repository;

import java.util.Optional;

import com.example.crud.models.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository2 extends JpaRepository<Pessoa, Integer>{
    
    public void deleteByCpf(String cpf);

    public Optional<Pessoa> findByCpf(String cpf);
}
