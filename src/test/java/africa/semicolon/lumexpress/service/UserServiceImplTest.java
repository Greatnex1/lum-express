package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.LoginRequest;
import africa.semicolon.lumexpress.data.models.Cart;
import africa.semicolon.lumexpress.data.models.Customer;
import africa.semicolon.lumexpress.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private CustomerRepository customerRepository;
    private LoginRequest   loginRequest;
    @BeforeEach
    void setUp() {
        var customer = Customer.builder().cart(new Cart()).build();
        customer.setFirstName("Noah");
        customer.setLastName("Will");
        customer.setEmail("noahgreat@gmail.com");
        customer.setPassword("iam");

        loginRequest= LoginRequest.builder()
                .email("noahgreat@gmail.com")
                .password("iam")
                .build();

        customerRepository.save(customer);

    }

    @Test
    void login() {
        var response = userService.login(loginRequest);
        assertThat(response).isNotNull();
        assertThat(response.getCode()).isEqualTo(200);
    }
}