package biz.geticard.wscard.repository;

import biz.geticard.wscard.model.Social;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lccf
 */
public interface SocialRepository extends JpaRepository<Social, Long> {
    
}
