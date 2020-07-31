/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.Cal.Repos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 *
 * @author piko
 */
@DataJpaTest
public class LessonRepoTest {
    
    @Autowired
    LessonRepo repo;
  
    @Test
    public void testSomeMethod() {
        
    }
    
}
