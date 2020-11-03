/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.front;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author piko
 */
@SpringBootTest
public class YearViewTest {
    
    @Autowired
    YearView year;
    
    public YearViewTest() {
    }

    @Test
    public void testSomeMethod() {
        System.out.println("bzzt");
    }
    
}
