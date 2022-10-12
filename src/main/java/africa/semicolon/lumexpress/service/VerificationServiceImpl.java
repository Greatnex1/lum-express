package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.Util.LumExpressUtils;
import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.exception.VerificationTokenException;
import africa.semicolon.lumexpress.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificationServiceImpl implements VerificationTokenService{

    private final VerificationTokenRepository verificationTokenRepository;


    @Override
    public VerificationToken createVerificationToken(String userEmail) {

        VerificationToken verificationToken  = VerificationToken.builder()
                .token(LumExpressUtils.generateToken())
                .userEmail(userEmail)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(5))
                .build();
        return verificationTokenRepository.save(verificationToken);
    }

    @Override
    public boolean isValidVerificationToken(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token)
                .orElseThrow(() -> new VerificationTokenException("token not found exception"));

        if(isTokenNotExpired(verificationToken))
            return true;

        throw new VerificationTokenException("token as expired");

    }

    private boolean isTokenNotExpired(VerificationToken verificationToken) {
        return  LocalDateTime.now().isBefore(verificationToken.getExpiresAt());
    }
}
