package biz.geticard.wscard.controller;

import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import biz.geticard.wscard.model.Card;
import biz.geticard.wscard.repository.CardRepository;

@RestController
@RequestMapping("/card")
public class CardController {
    CardRepository cardRepository;

    public CardController(CardRepository repository){
        this.cardRepository = repository;
    }

    @GetMapping
    public List<Card> findAll(){
        return this.cardRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id){
        try{
        Card resultado = this.cardRepository.findById(id).get();
        return ResponseEntity.ok(resultado);
        }catch(NoSuchElementException nosuch){
            return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Card create(@RequestBody Card card){
        return this.cardRepository.save(card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> delete(@PathVariable Long id){
        try{
        this.cardRepository.deleteById(id);
        return ResponseEntity.ok().build();
        }catch(EmptyResultDataAccessException exp){
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody Card card){
        return this.cardRepository.findById(id).map(record->{
            record.setEmail(card.getEmail());
            record.setMinibio(card.getMinibio());
            record.setName(card.getName());
            record.setPhone(card.getPhone());
            Card update = this.cardRepository.save(record);
            return ResponseEntity.ok().body(update);
        }).orElse(ResponseEntity.notFound().build());
    }



}
