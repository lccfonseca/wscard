package biz.geticard.wscard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lccf
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "social")
public class Social {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    String icon;
    String url;
    String profiles_url;
    
}
