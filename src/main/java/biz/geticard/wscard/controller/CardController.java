package biz.geticard.wscard.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.geticard.wscard.model.Card;
import biz.geticard.wscard.repository.CardRepository;

/*
Grupo1:
Felipe Martins Silva
Alex Dias
Ismael Freitas de Oliveira
Enzo Maldinni Montanha Rodrigues
 */
@RestController
@RequestMapping({"/card"})
public class CardController {
    
    CardRepository repository;

    public CardController(CardRepository repository) {
        this.repository = repository;
    }
            
    @GetMapping
    public List<Card> findAll(){
        return repository.findAll();
    }
    
    @PostMapping
    public Card create(@RequestBody Card card){
       return repository.save(card);
    }
    
    @GetMapping(value = "/{id}")
    public Card findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Card> update(@PathVariable("id") Long id,
            @RequestBody Card data) {
        return repository.findById(id)
                .map(record -> {
               record.setEmail(data.getEmail());
                record.setMinibio(data.getMinibio());
                record.setName(data.getName());
                record.setPhone(data.getPhone());
                    Card updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Card> delete(@PathVariable Long id){
        this.repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
