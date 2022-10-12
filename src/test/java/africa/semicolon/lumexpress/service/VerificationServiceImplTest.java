package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class VerificationServiceImplTest {
    private VerificationToken verificationToken;
@Autowired
    private   VerificationTokenService  verificationTokenService;
    @BeforeEach
    void setUp() {
        verificationToken = verificationTokenService.createVerificationToken("test@email.com");
    }

    @Test
    void generateToken() {
    }

    @Test
    void createTokenTest() {
        log.info("verification token object ->{}", verificationToken);
       verificationTokenService.createVerificationToken("test@email.com");
        assertThat(verificationToken).isNotNull();
        assertThat(verificationToken.getToken().length()).isEqualTo(5);
    }
    @Test
    void isValidVerificationTokenFirst(){
        assertThat(verificationToken).isNotNull();
        var response = verificationTokenService.isValidVerificationToken(verificationToken.getToken());
        assertThat(response).isTrue();
    }

}