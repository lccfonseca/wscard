package biz.geticard.wscard.repository;

import biz.geticard.wscard.model.CardSocial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lccf
 */
public interface CardSocialRepository extends JpaRepository<CardSocial, Long> {
    
}
