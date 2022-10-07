package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import lombok.AllArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;


public class VerificationServiceImpl implements VerificationTokenService{
    @Override
    public VerificationToken generateToke() {
        return null;
    }
}
