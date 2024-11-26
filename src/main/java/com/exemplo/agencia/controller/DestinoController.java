package com.exemplo.agencia.controller;

import com.exemplo.agencia.model.Destino;
import com.exemplo.agencia.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

    private final DestinoService destinoService;

    @Autowired
    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @PostMapping
    public ResponseEntity<Destino> cadastrarDestino(@RequestBody Destino destino) {
        Destino novoDestino = destinoService.salvarDestino(destino);
        return ResponseEntity.ok(novoDestino);
    }

    @GetMapping
    public ResponseEntity<List<Destino>> listarDestinos() {
        List<Destino> destinos = destinoService.listarDestinos();
        return ResponseEntity.ok(destinos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> obterDestino(@PathVariable Long id) {
        Destino destino = destinoService.obterDestino(id);
        return ResponseEntity.ok(destino);
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<Destino>> pesquisarDestinos(@RequestParam String nomeOuLocalizacao) {
        List<Destino> destinos = destinoService.pesquisarDestinos(nomeOuLocalizacao);
        return ResponseEntity.ok(destinos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destino> atualizarDestino(@PathVariable Long id, @RequestBody Destino destino) {
        Destino destinoAtualizado = destinoService.atualizarDestino(id, destino);
        return ResponseEntity.ok(destinoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDestino(@PathVariable Long id) {
        destinoService.excluirDestino(id);
        return ResponseEntity.noContent().build();
    }
}
