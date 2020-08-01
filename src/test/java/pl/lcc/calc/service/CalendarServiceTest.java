/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.service;

import java.time.LocalDate;
import java.time.Month;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import pl.lcc.calc.repos.FileToDB;

/**
 *
 * @author piko
 */
@DataJpaTest
@Import({FileToDB.class,CalendarService.class})
public class CalendarServiceTest {
    
    @Autowired
    CalendarService service;
    
    @Test
    public void testSomeMethod() {
        var result = service.getFromDay(LocalDate.of(2020, Month.MARCH, 13));
        
        assertThat(result).as("Events from 13.03.2020").hasSize(6);
        
    }
    
}
