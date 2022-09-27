package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dto.request.LoginRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dto.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.data.dto.response.LoginResponse;
import africa.semicolon.lumexpress.data.models.Address;
import africa.semicolon.lumexpress.data.models.Cart;
import africa.semicolon.lumexpress.data.models.Customer;
import africa.semicolon.lumexpress.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper = new ModelMapper();
    private final CartService cartService;

    public CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest) {
        Customer customer = mapper.map(registerRequest, Customer.class);
        customer.setCart(new Cart());
        var customerAddress = new Address();
        customerAddress.setCountry(registerRequest.getCountry());
        customer.getAddresses().add(customerAddress);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("customer to be saved in db ::{}", savedCustomer);
        System.out.println(savedCustomer);
        return registrationResponseBuilder(savedCustomer);
    }

    private CustomerRegistrationResponse registrationResponseBuilder(Customer customer) {
      return  CustomerRegistrationResponse.builder()
                .message("success")
                .userId(customer.getId())
                .code(201)
                .build();

    }


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public String completeProfile(UpdateCustomerDetails updateCustomerDetails) {
        return null;
    }
}
