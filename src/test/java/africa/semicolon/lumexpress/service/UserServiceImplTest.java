package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.LoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Sql(scripts="/home/nouah/Desktop/IdeaProjects/lum-express/src/test/java/resources/insert.sql")
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    private LoginRequest   loginRequest;
    @BeforeEach
    void setUp() {
        loginRequest= LoginRequest
                .builder()
                .email("yilati9582@haizail.com")
                .password("2234")
                .build();
    }

    @Test
    void login() {
        var response = userService.login(loginRequest);
        assertThat(response).isNotNull();
        assertThat(response.getCode()).isEqualTo(200);
    }
}