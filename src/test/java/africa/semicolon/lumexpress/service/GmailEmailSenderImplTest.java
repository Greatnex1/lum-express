package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.service.notification.EmailDetails;
import africa.semicolon.lumexpress.service.notification.EmailSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GmailEmailSenderImplTest {
    @Autowired
    private EmailSender emailSender;

    @Test
    void sendEmail() {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setUserEmail("noahgreatakoni@gmail.com");
        emailDetails.setMailContext("You are welcome to the online server");
        String response = emailSender.sendEmail(emailDetails);
        assertThat(response.contains("successfully")).isTrue();
    }
}