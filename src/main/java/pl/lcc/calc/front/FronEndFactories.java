/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.front;

import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.lcc.calc.service.LessonsSource;

/**
 *
 * @author piko
 */
@Slf4j
@Configuration
public class FronEndFactories {

    @Autowired
    private final LessonsSource service;
    
   // @Autowired
  //  private final SchoolDataDisplay schoolOutlet;
    
   // @Autowired
   //// private final TopicDataDisplay topicOutlet;

    public FronEndFactories(LessonsSource service ) {// , SchoolDataDisplay schoolOutlet, TopicDataDisplay topicOutlet
        this.service = service;
   //     this.schoolOutlet = schoolOutlet;
   //     this.topicOutlet = topicOutlet;
    }
    
        
    @Bean
    DayViewFactory dayFactory(){
        log.info("Day view Factory");
        return this::getDayView;
    }
    
    @Bean
    WeekViewFactory weekFactory(){
        log.info("Week view Factory");
        return (date)-> {
            return this.getWeekView(date).configure();
        };
    }
    
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    WeekView getWeekView(LocalDate day) {
        log.info("Get Week view Func");
        return new WeekView (service, day);
    }
    
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    DayView getDayView(LocalDate day){
        log.info("Get day view Func");
        return new DayView (service, day);
    }
    
}

@FunctionalInterface
interface DayViewFactory {

    public DayView getDayView(LocalDate date);
}

@FunctionalInterface
interface WeekViewFactory {

    public WeekView getWeekView(LocalDate date);
}
