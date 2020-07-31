/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.repos;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lcc.calc.entity.Lesson;
import pl.lcc.calc.entity.School;
import pl.lcc.calc.entity.Topic;
import pl.lcc.calc.entity.WetnesRating;

/**
 *
 * @author piko
 */
@Slf4j
@Configuration
public class FileToDB {

    @Autowired
    TopicRepo tRepo;

    @Autowired
    SchoolRepo sRepo;

    @Autowired
    LessonRepo lRepo;
    
    private static final String SCHOOL_PATH = "dbfiles/db_szkoly.txt";

    private static final String TOPIC_PATH = "dbfiles/db_topics.txt";
    
     private static final String FILE_PATH = "dbfiles/db.txt";

    @Bean
    CommandLineRunner LoadSchools() {
        return args -> {
             log.info("LoadSchools bean initialized with count: " + sRepo.count());
            sRepo.saveAll(loadSchoolFromFile());
            log.info("LoadSchools bean initialized with count: " + sRepo.count());
        };
    }

    @Bean
    CommandLineRunner LoadTopics() {
        return args -> {
            log.info("LoadTopics bean initialized with count: " + tRepo.count());
            tRepo.saveAll(loadTopicFromFile());
            log.info("LoadTopics bean initialized with count: " + tRepo.count());
        };
    }
    
     @Bean
    CommandLineRunner LoadLessons() {
        return args -> {
            log.info("LoadLessons bean initialized with count: " + lRepo.count());
            lRepo.saveAll(loadLessonsFromFile());
            log.info("LoadLessons bean initialized with count: " + lRepo.count());
        };
    }

    public List<School> loadSchoolFromFile() throws FileNotFoundException {
        return loadSchoolFromFile(SCHOOL_PATH);
    }

    public List<School> loadSchoolFromFile(String PATH) throws FileNotFoundException {
        List<School> schoolList = new LinkedList<>();
        try (var sc = new Scanner(new BufferedReader(new FileReader(PATH)))) {
            while (sc.hasNext()) {
                schoolList.add(new School(sc.nextLong(), sc.nextInt()));
            }
        }
        return schoolList;
    }

    public List<Topic> loadTopicFromFile() throws FileNotFoundException, IOException {
        return loadTopicFromFile(TOPIC_PATH);
    }

    public List<Topic> loadTopicFromFile(String PATH) throws FileNotFoundException, IOException {
        List<Topic> topicList = new LinkedList<>();
        try (var sc = new Scanner(new BufferedReader(new FileReader(PATH)))) {
            sc.nextLine();
            sc.useDelimiter("\t");
            while (sc.hasNext()) {
                var topic = new Topic();
                topic.setName(sc.next());
                topic.setWetnes(WetnesRating.getFromString(sc.next()));
                topic.setHelpingHand(sc.nextInt());
                topic.setYear(sc.nextInt());
                topic.setRemarks(sc.nextLine());
                topicList.add(topic);
            }

        }
        return topicList;
    }
    
    public List<Lesson> loadLessonsFromFile(String fileName) throws IOException, GeneralSecurityException {
       
        var gson = new GsonBuilder().create();
        LinkedList<Lesson> list = new LinkedList<>();
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            var token = new TypeToken<LinkedList<Lesson>>() {
            }.getType();
            list = gson.fromJson(reader, token);
        }
        return list;
    }
    
    public List<Lesson> loadLessonsFromFile() throws IOException , GeneralSecurityException{
        return loadLessonsFromFile(FILE_PATH);
    }

}
