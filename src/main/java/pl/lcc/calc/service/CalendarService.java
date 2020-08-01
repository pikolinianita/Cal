/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.service;

import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.lcc.calc.entity.Lesson;
import pl.lcc.calc.repos.LessonRepo;
import pl.lcc.calc.repos.SchoolRepo;
import pl.lcc.calc.repos.TopicRepo;

/**
 *
 * @author piko
 */
@Slf4j
@Service
public class CalendarService implements LessonsSource{
    
    TopicRepo tRepo;

    SchoolRepo sRepo;

    LessonRepo lRepo;

    public CalendarService(TopicRepo tRepo, SchoolRepo sRepo, LessonRepo lRepo) {
        this.tRepo = tRepo;
        this.sRepo = sRepo;
        this.lRepo = lRepo;
    }

    @Override
    public List<Lesson> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lesson> getFromDay(LocalDate date) {
        log.info("Service: getFromDate invoked with date " + date.toString());
        return lRepo.findByStartDate(date);
    }

    @Override
    public List<Lesson> getBetween(LocalDate start, LocalDate end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
