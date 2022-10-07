package africa.semicolon.lumexpress.service.notification;

public interface EmailSender {
    String sendEmail(EmailDetails emailDetails);
}
