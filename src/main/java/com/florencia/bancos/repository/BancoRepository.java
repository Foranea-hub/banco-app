package com.florencia.bancos.repository;

import com.florencia.bancos.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {

    Banco findByCodigo(String codigo);
}

