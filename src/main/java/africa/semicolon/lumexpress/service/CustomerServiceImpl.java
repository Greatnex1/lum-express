package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dto.request.EmailNotificationRequest;
import africa.semicolon.lumexpress.data.dto.request.LoginRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dto.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.data.dto.response.LoginResponse;
import africa.semicolon.lumexpress.data.models.Address;
import africa.semicolon.lumexpress.data.models.Cart;
import africa.semicolon.lumexpress.data.models.Customer;
import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.repository.CustomerRepository;
import africa.semicolon.lumexpress.service.notification.EmailNotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.webresources.FileResource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final ModelMapper mapper = new ModelMapper();
    private final CartService cartService;

    private final EmailNotificationService emailNotificationService;
    private  final  VerificationTokenService   verificationTokenService;

    private String getEmailTemplate  ()  {
        try (
            BufferedReader bufferedReader = new BufferedReader( new FileReader("/home/nouah/Desktop/IdeaProjects/lum-express/src/main/resources/welcome.txt") )){
            return bufferedReader.lines().collect(Collectors.joining());

        } catch (IOException err) {
            err.printStackTrace();
        }
return null;

    }
    public CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest) {
        Customer customer = mapper.map(registerRequest, Customer.class);
     //   CustomerRegistrationValidation validation = new CustomerRegistrationValidation();
      //  validation.isValidEmail();
        customer.setCart(new Cart());
        setCustomerAddress(registerRequest,customer);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("customer to be saved in db ::{}", savedCustomer);
        var token= verificationTokenService.createVerificationToken(savedCustomer.getEmail());
        emailNotificationService.sendEmail(buildEmailNotificationRequest(token));
        System.out.println(savedCustomer);
        return registrationResponseBuilder(savedCustomer);
    }

    private EmailNotificationRequest buildEmailNotificationRequest(VerificationToken  verificationToken) {
        var email = getEmailTemplate();
        String mail =  null;
        if(email !=null){
            mail = String.format(email, verificationToken.getUserEmail(),"http://localhost:8080/"+ verificationToken.getToken());
        }

      return  EmailNotificationRequest
                .builder()
                .userEmail(verificationToken.getUserEmail())
                .mailContext(mail)
                .build();

    }
    private void setCustomerAddress(CustomerRegistrationRequest registerRequest, Customer customer){
        Address customerAddress = new Address();
        customerAddress.setCountry(registerRequest.getCountry());
        customer.getAddresses().add(customerAddress);
    }

    private CustomerRegistrationResponse registrationResponseBuilder(Customer customer) {
      return  CustomerRegistrationResponse.builder()
                .message("success")
                .userId(customer.getId())
                .code(201)
                .build();

    }



    @Override
    public String completeProfile(UpdateCustomerDetails updateCustomerDetails) {
        return null;
    }
}
