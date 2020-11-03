/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.front;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.BiConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.lcc.calc.entity.Lesson;
import pl.lcc.calc.service.LessonsSource;

/**
 *
 * @author piko
 */

@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DayView extends VerticalLayout {

    private final LessonsSource service;
    
    private  SchoolDataDisplay schoolOutlet;
    
    private  TopicDataDisplay topicOutlet;

    Grid<Lesson> grid;
    
    Button addButton;

    private LocalDate day;

    @Autowired
    private SideWindow outputCall;
    
    public DayView(LessonsSource srv) {        
        this(srv,LocalDate.of(2020, Month.MARCH, 13));
        System.out.println("_______________----------------__________________Deprecated Call day viwe _______________----------------__________________");
//        this.service = srv;
//        day = LocalDate.of(2020, Month.MARCH, 13);
//        createElements();
       
    }

    public DayView(LessonsSource service, LocalDate day) {//, SchoolDataDisplay schO, TopicDataDisplay topO
        this.service = service;
      //  this.schoolOutlet = schO;
      //  this.topicOutlet = topO;
        this.day = day;
        createElements();
    }

    private void createElements() {
        log.info("Create Elements");      

        setStyles();
        
        var list = service.getFromDay(day);
        list.removeIf(lesson -> lesson.getTopic() == null || lesson.getSchool() == null);
        
        add(new Text(day.toString()));
        grid = new Grid<>();
        addButton = new Button ("Add Event");
        addButton.addClickListener(e -> new AddLessonDialog().open());
        
        
        grid.addColumn(TemplateRenderer.<Lesson>of(
                "<div style$=\"background-color:[[item.bkColor]]\"> [[item.topic]] <br> SP [[item.school]] </div>")
                .withProperty("topic", lesson -> lesson.getTopic().getName())
                .withProperty("bkColor", lesson -> lesson.getSchool().getYear() == 2 ? "lavender" : "moccasin")
                .withProperty("school", lesson -> lesson.getSchool().getSchoolNumber())
        )
                .setHeader(day.toString())
                .setFooter(addButton);
        grid.addItemClickListener(cL -> {
            System.out.println("listenrt");
            System.out.println(outputCall);
            outputCall.putTextIntoLabel(cL.getItem().getTopic().toString());
        }
        );
        
        grid.setItems(list);        
        add(grid);
    }

    private void setStyles() {
        setSpacing(false);
        setMargin(false);
        setPadding(false);
    }

}
