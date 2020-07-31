/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.google;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.lcc.calc.entity.Lesson;

/**
 *
 * @author piko
 */

@Component
@Slf4j
public class DefaultGoogleConnector implements GoogleConnector {

    public static final String KOLOROWO_ID = "hjimc4788te0h4222kdnjtdce4@group.calendar.google.com";
    
    private final Calendar calendar;

    public DefaultGoogleConnector(Calendar calendar) {
        this.calendar = calendar;
    }
        
    @Override
    public List<Lesson> getAllLessonsFromGoogle()  throws IOException, GeneralSecurityException {
      
        log.info("Get Lessons From Google invoked");
        
        var newYear = new DateTime(LocalDate.of(2019, 1, 1)
                .toEpochSecond(LocalTime.of(0, 0), ZoneOffset.UTC));

        Events events = calendar.events().list(KOLOROWO_ID)
                .setMaxResults(2500)
                .setSingleEvents(true)
                .execute();

        List<Lesson> result = new LinkedList();

        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            log.warn("No events found!!!");
        } else {
            log.info("Upcoming events: " + items.size());
            items.forEach((event) -> {
                try {                    
                    result.add(new Lesson(event));
                } catch (Exception ex) {
                    log.info("Exception thrown - Event: " + event.getSummary() + " " + event.getStart().getDateTime().toStringRfc3339());
                }
            });
        }
        return result;
    }
    

    @Override
    public void saveLessonToGoogle(Lesson L) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAllLessonsToGoogle(List<Lesson> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
