package com.caixa.cesoav4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> listarContratos() {
        return contratoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContratoPorId(@PathVariable Long id) {
        Optional<Contrato> contrato = contratoService.buscarPorId(id);
        return contrato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contrato> criarContrato(@RequestBody Contrato contrato) {
        Contrato contratoSalvo = contratoService.salvar(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> atualizarContrato(@PathVariable Long id, @RequestBody Contrato contrato) {
        if (!contratoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contrato.setId(id);
        Contrato contratoAtualizado = contratoService.salvar(contrato);
        return ResponseEntity.ok(contratoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContrato(@PathVariable Long id) {
        if (!contratoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contratoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}