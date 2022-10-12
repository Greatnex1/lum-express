package africa.semicolon.lumexpress.data.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginResponse {
    private String message;
    private int code;
}
