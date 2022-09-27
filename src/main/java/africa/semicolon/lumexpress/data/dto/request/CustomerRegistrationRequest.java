package africa.semicolon.lumexpress.data.dto.request;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistrationRequest {
    private String country;
    private String password;
    private String email;

}

