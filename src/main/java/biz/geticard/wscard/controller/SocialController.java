package biz.geticard.wscard.controller;

import biz.geticard.wscard.model.Social;
import biz.geticard.wscard.repository.SocialRepository;
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
@RequestMapping({"/social"})
public class SocialController {
    
    SocialRepository repository;

    public SocialController(SocialRepository repository) {
        this.repository = repository;
    }
            
    @GetMapping
    public List<Social> findAll(){
        return repository.findAll();
    }
    
    @PostMapping
    public Social create(@RequestBody Social social){
       return repository.save(social);
    }
    
    @GetMapping(value = "/{id}")
    public Social findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Social> update(@PathVariable("id") Long id,
            @RequestBody Social data) {
        return repository.findById(id)
                .map(record -> {
                    record.setDescription(data.getDescription());
                    record.setIcon(data.getIcon());
                    record.setUrl(data.getUrl());
                    record.setProfiles_url(data.getProfiles_url());
                    Social updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Social> delete(@PathVariable Long id){
        this.repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
