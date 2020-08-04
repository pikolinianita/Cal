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
import java.time.LocalDate;
import java.time.Month;
import lombok.extern.slf4j.Slf4j;
import pl.lcc.calc.entity.Lesson;
import pl.lcc.calc.service.LessonsSource;

/**
 *
 * @author piko
 */
//@Route
@Slf4j
public class DayView extends VerticalLayout {

    private final LessonsSource service;

    Grid<Lesson> grid;

    LocalDate day;

    public DayView(LessonsSource srv) {
        this.service = srv;
        day = LocalDate.of(2020, Month.MARCH, 13);
        createElements();
    }

    public DayView(LessonsSource service, LocalDate day) {
        this.service = service;
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
        //grid.getStyle().
        //grid.removeAllColumns();
        grid.addColumn(TemplateRenderer.<Lesson>of(
                "<div style$=\"background-color:[[item.bkColor]]\"> [[item.topic]] <br> SP [[item.school]] </div>")
                .withProperty("topic", lesson -> lesson.getTopic().getName())
                .withProperty("bkColor", lesson -> lesson.getSchool().getYear() == 2 ? "lavender" : "moccasin")
                .withProperty("school", lesson -> lesson.getSchool().getSchoolNumber())
        )
                .setHeader(day.toString())
                .setFooter( new Button ("Add Event"));
        grid.setItems(list);        
        add(grid);
    }

    private void setStyles() {
        setSpacing(false);
        setMargin(false);
        setPadding(false);
    }

}
