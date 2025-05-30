package br.com.gerenciador.api.controller;

import br.com.gerenciador.api.dto.FornecedorRequestDTO;
import br.com.gerenciador.api.dto.FornecedorResponseDTO;
import br.com.gerenciador.api.service.FornecedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorResponseDTO> criarFornecedor(@Valid @RequestBody FornecedorRequestDTO dto) {
       FornecedorResponseDTO fornecedorCriado = fornecedorService.criarFornecedor(dto);

       return ResponseEntity.status(201).body(fornecedorCriado);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> listarTodosFornecedores() {
        return ResponseEntity.ok(fornecedorService.listarTodosFornecedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> buscarFornecedorPeloId(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.buscarFornecedorPeloId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> atualizarFornecedorPeloId
            (@PathVariable Long id,
             @Valid @RequestBody FornecedorRequestDTO dto
             ) {
        return ResponseEntity.ok(fornecedorService.atualizarFornecedorPeloId(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedorPeloId(@PathVariable Long id) {
        fornecedorService.deletarFornecedorPeloId(id);
        return ResponseEntity.noContent().build();
    }


}
