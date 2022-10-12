package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.EmailNotificationRequest;
import africa.semicolon.lumexpress.service.notification.EmailNotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GmailEmailSenderImplTest {
    @Autowired
    private EmailNotificationService emailSender;

    @Test
    void sendEmail() {
        EmailNotificationRequest emailDetails = new EmailNotificationRequest();
        emailDetails.setUserEmail("noahgreatakoni@gmail.com");
        emailDetails.setMailContext("You are welcome to the online server");
        String response = emailSender.sendEmail(emailDetails);
        assertThat(response.contains("successful")).isTrue();
    }
}