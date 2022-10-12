package africa.semicolon.lumexpress.repository;

import africa.semicolon.lumexpress.data.models.Cart;
import africa.semicolon.lumexpress.data.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository  customerRepository;
    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    void findByEmailTest() {
      var   customer=  customerRepository.save(Customer
                .builder()
                        .cart(new Cart())
                .build());
      customer.setEmail("test@email.com");
      customer.setFirstName("John");
      customer.setLastName("Doe");
      customer.setPhoneNumber("123456789");
      var   savedCustomer=customerRepository.save(customer);
      assertThat(customerRepository.findByEmail(savedCustomer.getEmail())).isNotNull();
    }
}