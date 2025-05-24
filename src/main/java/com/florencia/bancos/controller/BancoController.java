package com.florencia.bancos.controller;

import com.florencia.bancos.model.Banco;
import com.florencia.bancos.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banco")
public class BancoController {

    @Autowired
    private BancoRepository bancoRepository;

    @PostMapping
    public Banco crearBanco(@RequestBody Banco banco) {
        return bancoRepository.save(banco);
    }

    @GetMapping
    public List<Banco> listarBancos() {
        return bancoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Banco> obtenerPorCodigo(@PathVariable String codigo) {
        Banco banco = bancoRepository.findByCodigo(codigo);
        if (banco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(banco);
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<Banco> actualizarBanco(@PathVariable String codigo, @RequestBody Banco detallesBanco) {
        Banco banco = bancoRepository.findByCodigo(codigo);
        if (banco == null) {
            return ResponseEntity.notFound().build();
        }

        banco.setNombre(detallesBanco.getNombre());
        banco.setActivo(detallesBanco.getActivo());
        banco.setDireccion(detallesBanco.getDireccion());
        banco.setPais(detallesBanco.getPais());
        banco.setFechaAlta(detallesBanco.getFechaAlta());

        Banco bancoActualizado = bancoRepository.save(banco);
        return ResponseEntity.ok(bancoActualizado);

    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> borrarBanco(@PathVariable String codigo) {
        Banco banco = bancoRepository.findByCodigo(codigo);
        if (banco == null) {
            return ResponseEntity.notFound().build();
        }

        bancoRepository.delete(banco);
        return ResponseEntity.noContent().build();
    }

}
