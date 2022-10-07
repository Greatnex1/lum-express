package africa.semicolon.lumexpress.repository;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.exception.VerificationTokenException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class VerificationTokenRepositoryTest {
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    private VerificationToken verificationToken;


@BeforeEach
void setUp(){
    verificationToken = new VerificationToken();
    verificationToken.setToken("12345");
    verificationToken.setUserEmail("test@gmail.com");

}
    @Test
    void findByUserEmail() {
    verificationTokenRepository.save(verificationToken);
   VerificationToken userToken = verificationTokenRepository.findByUserEmail("test@gmail.com")
           .orElseThrow(() -> new VerificationTokenException( " token not found"));
                   log.info("found token -> {}",userToken);

assertThat(userToken).isNotNull();
assertThat(userToken.getToken()). isEqualTo(verificationToken.getToken());
}

    @Test
    void findByToken() {
        verificationTokenRepository.save(verificationToken);
        VerificationToken token =  verificationTokenRepository.findByToken(verificationToken
                .getToken()).orElseThrow(()-> new VerificationTokenException("TOKEN NOT  FOUND"));
        assertThat(token).isNotNull();
        assertThat(token.getToken()).isEqualTo(verificationToken.getToken()).isEqualTo("12345");


    }
}