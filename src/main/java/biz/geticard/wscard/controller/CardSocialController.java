package biz.geticard.wscard.controller;

import biz.geticard.wscard.model.CardSocial;
import biz.geticard.wscard.repository.CardSocialRepository;
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



/*
Grupo1:
Felipe Martins Silva
Alex Dias
Ismael Freitas de Oliveira
Enzo Maldinni Montanha Rodrigues
 */

@RestController
@RequestMapping({"/cardsocial"})
public class CardSocialController {
    
    CardSocialRepository repository;

    public CardSocialController(CardSocialRepository repository) {
        this.repository = repository;
    }
            
    @GetMapping
    public List<CardSocial> findAll(){
        return repository.findAll();
    }
    
    @PostMapping
    public CardSocial create(@RequestBody CardSocial cardsocial){
       return repository.save(cardsocial);
    }
    
    @GetMapping(value = "/{id}")
    public CardSocial findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<CardSocial> update(@PathVariable("id") Long id,
            @RequestBody CardSocial data) {
        return repository.findById(id)
                .map(record -> {
                    record.setProfile(data.getProfile());
                    record.setLabel(data.getLabel());
                    CardSocial updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<CardSocial> delete(@PathVariable Long id){
        this.repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
