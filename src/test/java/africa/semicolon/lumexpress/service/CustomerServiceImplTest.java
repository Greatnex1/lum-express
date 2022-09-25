package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CustomerRegistrationRequest;
import lombok.Builder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Builder
class CustomerServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {
        CustomerRegistrationRequest request = CustomerRegistrationRequest
                .builder()
                .email("test@gmail")
                .password("2234")
                .country("Nigeria")

                .build();

    }

    @Test
    void login() {
    }

    @Test
    void completeProfile() {
    }
}