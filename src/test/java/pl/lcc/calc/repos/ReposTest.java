/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.repos;

import pl.lcc.calc.repos.FileToDB;
import pl.lcc.calc.repos.LessonRepo;
import pl.lcc.calc.repos.TopicRepo;
import pl.lcc.calc.repos.SchoolRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author piko
 */
@Slf4j
@DataJpaTest
@Import(FileToDB.class)
public class ReposTest {

    @Autowired
    TopicRepo tRepo;

    @Autowired
    SchoolRepo sRepo;

    @Autowired
    LessonRepo lRepo;

    @BeforeEach
    void initF(){
        log.info("Init");
    }
    
    @Test
    void ReposTest() {
        log.info("tRepo: " + tRepo.count());
        log.info("sRepo: " + sRepo.count());
        log.info("lRepo: " + lRepo.count());
    }

}
