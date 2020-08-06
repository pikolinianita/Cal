/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.front;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.Route;
import java.util.List;
import pl.lcc.calc.service.LessonsSource;

/**
 *
 * @author piko
 */
@Route
public class FrontView extends VerticalLayout {

    FrontViewHeader header;

    YearView weeks;

    SideWindow side;

    LessonsSource service;

    public FrontView(LessonsSource service) {
        this.service = service;
        header = new FrontViewHeader(this.service);
        add(header);

        side = new SideWindow(this.service);
        weeks = new YearView(this.service);
        
        
        var layout = new SplitLayout(side, weeks);
        layout.setSizeFull();
        add(layout);

    }

}

class FrontViewHeader extends HorizontalLayout {

    LessonsSource service;

    public FrontViewHeader(LessonsSource service) {
        this.service = service;
        var button = new Button("placeholder for header");
        add(button);
    }

}

class SideWindow extends VerticalLayout {

    LessonsSource service;

    public SideWindow(LessonsSource service) {
        this.service = service;
        var button = new Button("placeholder for side Bar");
        add(button);
    }

}

class YearView extends VerticalLayout {

    LessonsSource service;

    public YearView(LessonsSource service) {
        this.service = service;
        var week = new WeekView(service);
        var week2 = new WeekView(service);
        var week3 = new WeekView(service);
        //getStyle().set("display","block");
       
        add(week, week2, week3);
    }

}
