package com.example.projetmicroservice.Controller;
import com.example.projetmicroservice.DTO.ProjetRequestDTO;
import com.example.projetmicroservice.DTO.ProjetResponseDTO;
import com.example.projetmicroservice.Service.ProjetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projets")
public class ProjetController {

    private final ProjetService service;

    public ProjetController(ProjetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProjetResponseDTO> create(@RequestBody ProjetRequestDTO req){
        var saved = service.create(req);
        return ResponseEntity.created(URI.create("/projets/" + saved.id)).body(saved);
    }

    @GetMapping
    public List<ProjetResponseDTO> all(){
        return service.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetResponseDTO> one(@PathVariable Integer id){
        var dto = service.one(id);
        return (dto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetResponseDTO> update(@PathVariable Integer id, @RequestBody ProjetRequestDTO req){
        var dto = service.update(id, req);
        return (dto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/by-chercheur/{chercheurId}")
    public List<ProjetResponseDTO> byChercheur(@PathVariable Integer chercheurId){
        return service.byChercheur(chercheurId);
    }
}
