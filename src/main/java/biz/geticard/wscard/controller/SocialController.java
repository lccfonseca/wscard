package biz.geticard.wscard.controller;

import biz.geticard.wscard.model.Social;
import biz.geticard.wscard.repository.SocialRepository;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lccf
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
    @ResponseStatus(HttpStatus.CREATED)
    public Social adicionar(@RequestBody Social social){
        return repository.save(social);
    }
    
}
