/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.Cal.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lcc.Cal.Entity.Topic;

/**
 *
 * @author piko
 */
public interface TopicRepo extends JpaRepository<Topic, Long>{
    
}
