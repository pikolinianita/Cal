/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.front;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pl.lcc.calc.entity.School;
import pl.lcc.calc.entity.Topic;
import pl.lcc.calc.service.LessonsSource;

/**
 *
 * @author piko
 */
@Route
public class FrontView extends VerticalLayout {

    FrontViewHeader header;

    YearView weeks;

    SideWindow sideView;

    LessonsSource service;

    public FrontView(LessonsSource service, SideWindow side, YearView year, FrontViewHeader top) {
        this.service = service;
        header = top;
        add(header);
        
        sideView = side;
        weeks = year;        
        var layout = new SplitLayout(sideView, weeks);
        layout.setSizeFull();
        add(layout);

    }
}

@Component
@UIScope
class FrontViewHeader extends HorizontalLayout {

    LessonsSource service;

    public FrontViewHeader(LessonsSource service) {
        this.service = service;
        var button = new Button("placeholder for header");
        add(button);
    }

}

@Component
@UIScope
class SideWindow extends VerticalLayout { //implements SchoolDataDisplay, TopicDataDisplay

    LessonsSource service;

    Label description;
    
    Label desLabel2;
    
    public SideWindow(LessonsSource service) {
        this.service = service;
        var button = new Button("placeholder for side Bar");
        add(button);
        description = new Label("Default text");
        desLabel2 = new Label("Default text");
        add(description, desLabel2);
        
    }

    public void putTextIntoLabel(String newText){
        description.setText(newText);
           }

 //   @Override
    public void displayLessonsFromSchool(School s) {
        description.setText("Lessons From School Displayed");
    }

 //   @Override
    public void displaySchoolsWithTopic(Topic t) {
        desLabel2.setText("Topics Displayed");
    }
    
}
@Component
@UIScope
class YearView extends VerticalLayout {

    LessonsSource service;
    
    WeekViewFactory weekFact;

    public YearView(LessonsSource service, WeekViewFactory weekFactory) {
        this.service = service;
        this.weekFact = weekFactory;
        var startDate = LocalDate.of(2020, Month.MARCH, 9);
        var week = weekFact.getWeekView(startDate);
        var week2 = weekFact.getWeekView(startDate.plusDays(7));
        var week3 = weekFact.getWeekView(startDate.plusDays(14));
        //getStyle().set("display","block");
       
        add(week, week2, week3);
    }

}

