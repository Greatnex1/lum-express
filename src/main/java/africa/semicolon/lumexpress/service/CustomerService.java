package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dto.request.LoginRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dto.response.CustomerRegisterResponse;
import africa.semicolon.lumexpress.data.dto.response.LoginResponse;

public interface CustomerService {
    CustomerRegisterResponse register(CustomerRegistrationRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);

    String completeProfile(UpdateCustomerDetails updateCustomerDetails);
}
