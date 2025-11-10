package com.example.enseignantmicroservice.Controlller;

import com.example.enseignantmicroservice.EnseignantDTO.EnseignantRequestDTO;
import com.example.enseignantmicroservice.EnseignantDTO.EnseignantResponseDTO;
import com.example.enseignantmicroservice.Entities.Enseignant;
import com.example.enseignantmicroservice.Service.EnseignantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {

    private final EnseignantService service;

    public EnseignantController(EnseignantService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<EnseignantResponseDTO> create(@RequestBody EnseignantRequestDTO req) {
        EnseignantResponseDTO saved = service.create(req);
        return ResponseEntity.created(URI.create("/enseignants/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<EnseignantResponseDTO> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnseignantResponseDTO> one(@PathVariable Integer id) {
        var dto = service.one(id);
        return (dto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnseignantResponseDTO> update(@PathVariable Integer id, @RequestBody EnseignantRequestDTO req) {
        var dto = service.update(id, req);
        return (dto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}