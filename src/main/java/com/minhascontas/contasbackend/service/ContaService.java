package com.minhascontas.contasbackend.service;

import com.minhascontas.contasbackend.model.Conta;
import com.minhascontas.contasbackend.repository.ContaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Transactional(readOnly = true)
    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Conta> findById(Long id) {
        return contaRepository.findById(id);
    }

    @Transactional
    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }

    @Transactional
    public void deleteById(Long id) {
        contaRepository.deleteById(id);
    }

    @Transactional
    public Conta update(Long id, Conta contaAtualizada) {
        return contaRepository.findById(id).map(contaExistente -> {
            contaExistente.setDescricao(contaAtualizada.getDescricao());
            contaExistente.setValor(contaAtualizada.getValor());
            contaExistente.setCategoria(contaAtualizada.getCategoria());
            contaExistente.setDataVencimento(contaAtualizada.getDataVencimento());
            contaExistente.setStatusPagamento(contaAtualizada.getStatusPagamento());

            return contaRepository.save(contaExistente);
        }).orElseThrow(() -> new RuntimeException("Conta não encontrada com ID: " + id));
    }
}