package africa.semicolon.lumexpress.repository;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken>  findByUserEmail(String  userEmail);
    Optional<VerificationToken>  findByToken(String token);

}
