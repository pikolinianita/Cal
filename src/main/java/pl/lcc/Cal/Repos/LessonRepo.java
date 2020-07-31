/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.Cal.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.lcc.Cal.Entity.Lesson;
import pl.lcc.Cal.Entity.School;
import pl.lcc.Cal.Entity.Topic;

/**
 *
 * @author piko
 */
public interface LessonRepo extends JpaRepository<Lesson, Long> {
    
//    @Query("Select s from School s where s.schoolNumber = :number")
//    School getSchool(Long number);
//    
//    @Query("Select t from Topic t where t.name = :name")
//    Topic getTopic(String name);
}
