package  pl.lcc.calc.google;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
class SheetsServiceUtil {

    private static final String APPLICATION_NAME = "Google Sheets Example";

    static Credential credential;
    
//    private SheetsServiceUtil(){
//        //blocker
//    }
    @Bean
    public Sheets getSheetsService() throws IOException, GeneralSecurityException {
        log.info("---------------SheetService Bean");
        if (credential == null) {
       //  credential = GoogleAuthorizeUtil.authorize();
        }
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
    }

    @Bean
    public Calendar getCalendarService() throws IOException, GeneralSecurityException {
         log.info("--------------Calendar Bean");
        if (credential == null) {
    //     credential = GoogleAuthorizeUtil.authorize();
        }
         return new Calendar.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
    }
}
