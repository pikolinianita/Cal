/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.service;

import java.time.LocalDate;
import java.util.List;
import pl.lcc.calc.entity.Lesson;

/**
 *
 * @author piko
 */
public interface LessonsSource {
    
    List<Lesson> getAll();
    
    List<Lesson> getFromDay(LocalDate date);
    
    List<Lesson> getBetween(LocalDate start, LocalDate end);
    
}
