/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.front;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.textfield.TextField;

/**
 *
 * @author piko
 */
public class AddLessonDialog extends Dialog{

    public AddLessonDialog() {
        FormLayout columnLayout = new FormLayout();
// Setting the desired responsive steps for the columns in the layout
columnLayout.setResponsiveSteps(
           new ResponsiveStep("25em", 1),
           new ResponsiveStep("32em", 2),
           new ResponsiveStep("40em", 3));
   TextField firstName = new TextField();
   firstName.setPlaceholder("First Name");
   TextField lastName = new TextField();
   lastName.setPlaceholder("Last Name");
   TextField email = new TextField();
   email.setPlaceholder("Email");
   TextField nickname = new TextField();
   nickname.setPlaceholder("Username");
   TextField website = new TextField();
   website.setPlaceholder("Link to personal website");
   TextField description = new TextField();
   description.setPlaceholder("Enter a short description about yourself");
   columnLayout.add(firstName, lastName,  nickname, email, website); 
   // You can set the desired column span for the components individually.
   columnLayout.setColspan(website, 2);
   // Or just set it as you add them.
   columnLayout.add(description, 3);
   add(columnLayout);
    }
    
    
    
    
}
