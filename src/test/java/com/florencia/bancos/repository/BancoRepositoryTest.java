package com.florencia.bancos.repository;

import com.florencia.bancos.model.Banco;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BancoRepositoryTest {

    @Autowired
    private BancoRepository bancoRepository;

    @Test
    void findByCodigo() {
        // Crear y guardar un banco de prueba
        Banco banco = new Banco();
        banco.setCodigo("B001");
        banco.setNombre("Banco Gabug");
        banco.setPais("Argentina");
        banco.setActivo(true);
        banco.setFechaAlta(LocalDate.now());

        System.out.println("Guardando banco: " + banco.getNombre());
        bancoRepository.save(banco);

        Banco encontrado = bancoRepository.findByCodigo("B001");

        System.out.println("Banco encontrado: " + encontrado.getNombre());

        assertNotNull(encontrado);
        assertEquals("Banco Gabug", encontrado.getNombre());
        assertEquals("Argentina", encontrado.getPais());
    }
}
