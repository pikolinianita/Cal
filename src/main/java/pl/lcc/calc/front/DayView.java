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
import pl.lcc.calc.entity.Lesson;
import pl.lcc.calc.repos.LessonRepo;

/**
 *
 * @author piko
 */
@Route
public class DayView extends VerticalLayout {    
    
    private final LessonRepo repo;
    
    Grid<Lesson> grid;     
    
    public DayView(LessonRepo repo) {
        this.repo = repo;
        add(new Text("Welcome to MainView."));
        grid = new Grid<>(Lesson.class);
        add(grid);
        grid.setColumns("topic", "school", "week");
        grid.setItems(repo.findAll());
        grid.getDataProvider().refreshAll();
    }
    
}
