package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dto.request.LoginRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dto.response.CustomerRegisterResponse;
import africa.semicolon.lumexpress.data.dto.response.LoginResponse;
import africa.semicolon.lumexpress.data.models.LumExpressUser;

import java.util.function.LongUnaryOperator;

public class CustomerServiceImpl implements CustomerService{
    @Override
    public CustomerRegisterResponse register(CustomerRegistrationRequest registerRequest) {
        CustomerRegistrationRequest registrationRequest  =  new CustomerRegistrationRequest();
        registrationRequest.setEmail(" ");
        CustomerRegisterResponse registrationResponse = new CustomerRegisterResponse();
        registrationResponse.setMessage("Registration completed");

        return  registrationResponse;
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
