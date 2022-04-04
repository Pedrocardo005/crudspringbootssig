package com.example.crud.controller;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.example.crud.models.Pessoa;
import com.example.crud.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<ArrayList<Pessoa>> findAll() {
        ArrayList<Pessoa> pessoas = pessoaService.findAll();

        return new ResponseEntity<ArrayList<Pessoa>>(pessoas, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.cadastrarPessoa(pessoa);
        return new ResponseEntity<String>("Criado", HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<String> deletar(@PathVariable String cpf) {
        pessoaService.deletar(cpf);
        return new ResponseEntity<String>("deletado", HttpStatus.OK);
    }

    @GetMapping(value = "/find", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView findByCpf(@RequestParam String cpf, Model model){
        Pessoa pessoa = pessoaService.findByCpf(cpf);
        model.addAttribute("nome", pessoa.getNome());
        model.addAttribute("cpf", pessoa.getCpf());
        model.addAttribute("sexo", pessoa.getSexo());
        return new ModelAndView("atualizar");
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Pessoa> update(Pessoa pessoa) {
        try {
            pessoaService.update(pessoa);

            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
