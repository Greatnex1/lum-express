package africa.semicolon.lumexpress.data.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EmailNotificationRequest {
    private String userEmail;
    private  String mailContext;

}
