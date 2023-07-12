package biz.geticard.wscard.controller;


import biz.geticard.wscard.model.Card;
import biz.geticard.wscard.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardRepository repository;

    @GetMapping
    public ResponseEntity<List<Card>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Card> create(@RequestBody Card card) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(card));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> delete(@PathVariable Long id) {
        return repository.findById(id).map(c -> {
            repository.delete(c);
            return ResponseEntity.ok(c);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody Card card) {
        return repository.findById(id).map(c -> {
            c.setEmail(card.getEmail());
            c.setMinibio(card.getMinibio());
            c.setName(card.getName());
            c.setPhone(card.getPhone());
            return ResponseEntity.ok().body(repository.save(c));
        }).orElse(ResponseEntity.notFound().build());
    }


}
