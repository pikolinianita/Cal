/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.google;

import pl.lcc.calc.google.GoogleConnector;
import java.io.IOException;
import java.security.GeneralSecurityException;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author piko
 */
@Disabled
@SpringBootTest
public class DefaultGoogleConnectorTest {
    
    @Autowired
    GoogleConnector connector;
    
    public DefaultGoogleConnectorTest() {
    }

    @Test
    public void testSomeMethod() throws IOException, GeneralSecurityException {
        var list = connector.getAllLessonsFromGoogle();
        
        assertThat(list).as("all events from google").hasSizeGreaterThan(2);
    }
    
}
