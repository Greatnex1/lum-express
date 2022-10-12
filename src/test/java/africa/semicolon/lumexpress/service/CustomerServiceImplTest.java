package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dto.response.CustomerRegistrationResponse;
import lombok.Builder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;

private  CustomerRegistrationRequest request;
    @BeforeEach
    void setUp() {
         request = CustomerRegistrationRequest

          .builder()
                .email("yilati9582@haizail.com")
                .password("2234")
                .country("Nigeria")

                .build();
    }

    @Test
    void register() {
        CustomerRegistrationResponse customerRegistrationResponse = customerService.register(request);
        assertThat(customerRegistrationResponse).isNotNull();
        assertThat(customerRegistrationResponse.getMessage()).isNotNull();
        assertThat(customerRegistrationResponse.getUserId()).isGreaterThan(0);
        assertThat(customerRegistrationResponse.getCode()).isEqualTo(201);
    }


    @Test
    void completeProfile() {
    }
}