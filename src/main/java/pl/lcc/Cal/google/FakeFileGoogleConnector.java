/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.Cal.google;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.lcc.Cal.Entity.Lesson;

/**
 *
 * @author piko
 */
@Component
public class FakeFileGoogleConnector implements GoogleConnector{

    @Override
    public List<Lesson> getAllLessonsFromGoogle() throws IOException, GeneralSecurityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveLessonToGoogle(Lesson L) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAllLessonsToGoogle(List<Lesson> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
