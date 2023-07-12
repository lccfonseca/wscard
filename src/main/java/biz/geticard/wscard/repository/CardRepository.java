package biz.geticard.wscard.repository;

import biz.geticard.wscard.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
