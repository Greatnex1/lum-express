package africa.semicolon.lumexpress.Util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class LumExpressUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void generateToken() {
        String token = LumExpressUtils.generateToken();
        log.info("token -> {}",token);
        assertThat(token).isNotNull();
        assertThat(token.length()).isEqualTo(5);
    }

}