/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.front;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.IntStream;
import pl.lcc.calc.service.LessonsSource;

/**
 *
 * @author piko
 */
@Route
public class WeekView extends HorizontalLayout {
    
    DayView[] week = new DayView[5];
    
    LessonsSource service;

    public WeekView(LessonsSource service) {
        this.service = service;        
        var startDate = LocalDate.of(2020, Month.MARCH, 9);
        
        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setSizeFull();
        
        IntStream.rangeClosed(0, 4)
                .forEach(i -> {week[i] = 
                        new DayView(service, startDate.plusDays(i));
                        add(week[i]);
                                });
    }
    
    
}
