/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lcc.calc.entity;

import com.google.api.services.calendar.model.Event;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
//import pl.luccasso.calendarfiles.repo.SchoolRepo;
//import pl.luccasso.calendarfiles.repo.TopicRepository;

/**
 *
 * @author piko
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "Lessons")
public class Lesson implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
     
    @NaturalId
    @Column(name = "googleID")
    String googleID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name")
    Topic topic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schoolNumber")
    School school;

    @Column(name = "tx")
    String week;

    @Column(name = "StartDate")
    LocalDate startDate;

    @Column(name = "update_status")
    UpdateStatus status;

    @Column(name = "remerks")
    String remarks;

    private static Pattern spacePattern = Pattern.compile(" ");
    private static Pattern earPattern = Pattern.compile("\"");
   
    public Lesson() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    void setId(Long newValue) {
//        id = newValue;
//    }

    public Lesson(Event eventGoogle) {

        splitTitle(eventGoogle.getSummary());
        startDate = LocalDate.parse(eventGoogle.getStart().getDate().toStringRfc3339());
        googleID = eventGoogle.getId();
        status = UpdateStatus.ORIGINAL;
    }

    private void splitTitle(String eventTitle) {
        //TODO better pattern in If, better pattern in topic if
        if (eventTitle.startsWith("SP") || eventTitle.startsWith("sp")) {
            try (var sc = new Scanner(eventTitle).useDelimiter(spacePattern)) {
                var schoolNr = Long.parseLong(sc.next().substring(2));
                if (schoolNr > 0){
                 //  school = SchoolRepo.getInstance().findByName(schoolNr);
                }
                week = sc.next();
                sc.useDelimiter(earPattern);
                if (sc.hasNext()) {
                    sc.next();
                    String topicTmp = sc.next();
                  //  topic = TopicRepository.getInstance().findByName(topicTmp);
                }
                if (sc.hasNext()) {
                    remarks = sc.next();
                }
            }
        }
    }
}
