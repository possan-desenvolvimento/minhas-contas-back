package com.minhascontas.contasbackend.controller;

import com.minhascontas.contasbackend.model.Conta;
import com.minhascontas.contasbackend.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas") 
@CrossOrigin(origins = {"http://localhost:8000", "http://127.0.0.1:5500"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.OPTIONS}, allowedHeaders = "*", allowCredentials = "true")

public class ContaController {

    private final ContaService contaService; 
    
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }
    
    @PostMapping
    public ResponseEntity<Conta> createConta(@RequestBody Conta conta) {    
        Conta novaConta = contaService.save(conta);
        
        return new ResponseEntity<>(novaConta, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Conta>> getAllContas() {
        List<Conta> contas = contaService.findAll();
        
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
        
        return contaService.findById(id)
                .map(conta -> new ResponseEntity<>(conta, HttpStatus.OK)) 
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@PathVariable Long id, @RequestBody Conta conta) {
        try {
            Conta contaAtualizada = contaService.update(id, conta);
            return new ResponseEntity<>(contaAtualizada, HttpStatus.OK);
        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long id) {
        contaService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}