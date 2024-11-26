package com.exemplo.agencia.service;

import com.exemplo.agencia.model.Destino;
import com.exemplo.agencia.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoService {

    private final DestinoRepository destinoRepository;

    @Autowired
    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    public Destino salvarDestino(Destino destino) {
        return destinoRepository.save(destino);
    }

    public List<Destino> listarDestinos() {
        return destinoRepository.findAll();
    }

    public Destino obterDestino(Long id) {
        return destinoRepository.findById(id).orElse(null);
    }

    public List<Destino> pesquisarDestinos(String nomeOuLocalizacao) {
        return destinoRepository.findByNomeContainingOrLocalizacaoContaining(nomeOuLocalizacao, nomeOuLocalizacao);
    }

    public Destino atualizarDestino(Long id, Destino destino) {
        if (!destinoRepository.existsById(id)) {
            throw new RuntimeException("Destino não encontrado");
        }
        destino.setId(id);
        return destinoRepository.save(destino);
    }

    public void excluirDestino(Long id) {
        destinoRepository.deleteById(id);
    }
}
