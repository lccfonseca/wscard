package biz.geticard.wscard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.geticard.wscard.model.Card;

public interface CardRepository extends JpaRepository<Card,Long>{
    
}
