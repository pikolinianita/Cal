/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.front;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import pl.lcc.calc.service.LessonsSource;

/**
 *
 * @author piko
 */

public class WeekView extends HorizontalLayout {

    DayView[] week = new DayView[5];

    LessonsSource service;

    @Autowired
    ApplicationContext ctx;
    
    @Autowired
    DayViewFactory dayFactory;

    LocalDate startDate;
    
    WeekView(LessonsSource service, LocalDate day) {
        
         System.out.println("week Constr. service: " + this.service);
         this.service = service;
        startDate = day;
    }

    public WeekView configure(){
        System.out.println("3week Configure. service: " + this.service);
        System.out.println("is DayViewFactory: " + dayFactory);
        System.out.println("What date: " + startDate.toString());
        System.out.println("is app binded: " + ctx);
        System.out.println("is Context: " + ctx.getApplicationName());
        System.out.println("has beans: " + Arrays.toString(ctx.getBeanDefinitionNames()));
        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setSizeFull();

        IntStream.rangeClosed(0, 4)
                .forEach(i -> {
                    week[i] = dayFactory.getDayView(startDate.plusDays(i));
                    add(week[i]);
                });
        return this;
    }
    
}
