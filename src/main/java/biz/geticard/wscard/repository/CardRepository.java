package biz.geticard.wscard.repository;

import biz.geticard.wscard.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lccf
 */
public interface CardRepository extends JpaRepository<Card, Long> {
    
}
