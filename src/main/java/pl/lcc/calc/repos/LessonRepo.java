/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.repos;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.lcc.calc.entity.Lesson;
import pl.lcc.calc.entity.School;
import pl.lcc.calc.entity.Topic;

/**
 *
 * @author piko
 */
public interface LessonRepo extends JpaRepository<Lesson, Long> {

    @Query("Select l from Lesson l where l.startDate = :date")
    public List<Lesson> findByStartDate(LocalDate date);
    
//    @Query("Select s from School s where s.schoolNumber = :number")
//    School getSchool(Long number);
//    
//    @Query("Select t from Topic t where t.name = :name")
//    Topic getTopic(String name);
}
