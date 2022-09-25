package africa.semicolon.lumexpress.data.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterResponse {
    private  String message;
    private  int code;
}
