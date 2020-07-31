/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.google;

import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.lcc.calc.entity.Lesson;

/**
 *
 * @author piko
 */
@Component
public class FakeFileGoogleConnector implements GoogleConnector{

     private static final String FILE_PATH = "dbfiles/db.txt";
    
    public List<Lesson> loadFromFile(String fileName) throws IOException, GeneralSecurityException {
       
        var gson = new GsonBuilder().create();
        LinkedList<Lesson> list = new LinkedList<>();
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            var token = new TypeToken<LinkedList<Lesson>>() {
            }.getType();
            list = gson.fromJson(reader, token);
        }
        return list;
    }
    @Override
     public List<Lesson> getAllLessonsFromGoogle() throws IOException , GeneralSecurityException{
        return loadFromFile(FILE_PATH);
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
