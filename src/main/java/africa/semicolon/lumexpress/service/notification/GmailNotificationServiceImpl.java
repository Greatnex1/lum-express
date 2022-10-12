package africa.semicolon.lumexpress.service.notification;

import africa.semicolon.lumexpress.data.dto.request.EmailNotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Service
@AllArgsConstructor
@Slf4j
public class GmailNotificationServiceImpl implements EmailNotificationService {

    private final JavaMailSender javaMailSender;
    @Override
    public String sendEmail(EmailNotificationRequest emailDetails) {
        MimeMessage  mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

                try{

                    mimeMessageHelper.setFrom("noreply@gmail.lum");
                    mimeMessageHelper.setTo(emailDetails.getUserEmail());
                    mimeMessageHelper.setText(emailDetails.getMailContext(),true);
                    javaMailSender.send(mimeMessage);
                    return  String.format("email sent to %s successfully",emailDetails.getUserEmail());
                }catch(MessagingException err){
                    err.printStackTrace();
                }
                return String.format("email not sent to %s", emailDetails.getUserEmail());
    }
}
