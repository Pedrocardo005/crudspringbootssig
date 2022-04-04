package com.example.crud.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.crud.models.Pessoa;
import com.example.crud.repository.PessoaRepository;
import com.example.crud.repository.PessoaRepository2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaRepository2 pessoaRepository2;

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoaRepository2.save(pessoa);
    }

    public ArrayList<Pessoa> findAll() {
        return (ArrayList<Pessoa>) pessoaRepository2.findAll();
    }

    public void deletar(String cpf) {
        pessoaRepository2.deleteByCpf(cpf);
    }

    public Pessoa findByCpf(String cpf) {
        return pessoaRepository2.findByCpf(cpf).get();
    }

    public void update(Pessoa pessoa) throws Exception{
        Optional<Pessoa> p = pessoaRepository2.findByCpf(pessoa.getCpf());

        if (p.isPresent()) {
            Integer id = p.get().getId();
            pessoa.setId(id);
            pessoaRepository2.save(pessoa);
        } else {
            System.out.println("Não existe uma pessoa com o cpf buscado!");
            throw new Exception("Não existe uma pessoa com o cpf buscado!");
        }
    }
}
