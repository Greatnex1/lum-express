package africa.semicolon.lumexpress.controller;

import africa.semicolon.lumexpress.data.dto.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.service.CustomerService;
import lombok.AllArgsConstructor;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<?> register(@RequestBody CustomerRegistrationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.register(request));
    }
}