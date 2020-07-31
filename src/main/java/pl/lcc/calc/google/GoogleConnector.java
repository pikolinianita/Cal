/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.google;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import pl.lcc.calc.entity.Lesson;

/**
 *
 * @author piko
 */
public interface GoogleConnector {
    
    List<Lesson> getAllLessonsFromGoogle() throws IOException, GeneralSecurityException;
    
    void saveLessonToGoogle(Lesson L);
    
    void saveAllLessonsToGoogle(List<Lesson> list);
    
}
