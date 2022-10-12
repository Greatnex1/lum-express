package africa.semicolon.lumexpress.Validation;

import africa.semicolon.lumexpress.exception.CustomerRegistrationException;

public class CustomerRegistrationValidation {

public void  isValidPassword(String password) throws CustomerRegistrationException {
    
    if (password.length() != 8) {
        String regex = "^[a-zA-Z0-9]\\w{5,29}$";
        throw  new CustomerRegistrationException("A weak password");
    }
}
public void  isValidEmail(String email){
    if(email.contains(email.toUpperCase())){

    }

}

}