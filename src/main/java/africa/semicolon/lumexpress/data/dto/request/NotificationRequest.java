package africa.semicolon.lumexpress.data.dto.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class NotificationRequest {

    private  Long userId;
    private String message;
}
