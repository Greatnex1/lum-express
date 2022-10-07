package africa.semicolon.lumexpress.repository;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.service.notification.Notification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken>  findByUserEmail(String  userEmail);
    Optional<VerificationToken>  findByToken(String token);

}
