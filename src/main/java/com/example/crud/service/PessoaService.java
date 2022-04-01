package com.example.crud.service;

import java.util.ArrayList;

import com.example.crud.models.Pessoa;
import com.example.crud.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    @Autowired
    PessoaRepository pessoaRepository;

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoaRepository.cadastrarPessoa(pessoa);
    }

    public ArrayList<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public void deletar(String cpf) {
        pessoaRepository.deletar(cpf);
    }
}
