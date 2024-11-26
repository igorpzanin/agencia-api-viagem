package com.exemplo.agencia.repository;

import com.exemplo.agencia.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinoRepository extends JpaRepository<Destino, Long> {

    List<Destino> findByNomeContainingOrLocalizacaoContaining(String nome, String localizacao);

}
