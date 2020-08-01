/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.front;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;
import java.time.Month;
import pl.lcc.calc.entity.Lesson;
import pl.lcc.calc.service.LessonsSource;

/**
 *
 * @author piko
 */
@Route
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
        add(new Text(day.toString()));
        grid = new Grid<>(Lesson.class);
        add(grid);
        grid.setColumns("topic", "school", "week");
        grid.setItems(service.getFromDay(day));
        grid.getDataProvider().refreshAll();
    }

}
