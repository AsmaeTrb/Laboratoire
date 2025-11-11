package com.example.chercheursmicroservice.Conroller;
import com.example.chercheursmicroservice.ChercheursDTO.ChercheurRequestDTO;
import com.example.chercheursmicroservice.ChercheursDTO.ChercheurResponseDTO;
import com.example.chercheursmicroservice.Service.ChercheurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/chercheurs")
public class ChercheurController {

    private final ChercheurService service;

    public ChercheurController(ChercheurService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ChercheurResponseDTO> create(@RequestBody ChercheurRequestDTO req) {
        var saved = service.create(req);
        return ResponseEntity.created(URI.create("/chercheurs/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<ChercheurResponseDTO> all() { return service.all(); }

    @GetMapping("/{id}")
    public ResponseEntity<ChercheurResponseDTO> one(@PathVariable Integer id) {
        var dto = service.one(id);
        return (dto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChercheurResponseDTO> update(@PathVariable Integer id, @RequestBody ChercheurRequestDTO req) {
        var dto = service.update(id, req);
        return (dto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // ⚠️ Nécessaire pour le calcul de stats côté Enseignant-service (Feign)
    @GetMapping("/by-enseignant/{enseignantId}")
    public List<ChercheurResponseDTO> byEnseignant(@PathVariable Integer enseignantId) {
        return service.byEnseignant(enseignantId);
    }
}
