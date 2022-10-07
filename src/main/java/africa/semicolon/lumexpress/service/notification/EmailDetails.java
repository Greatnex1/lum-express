package africa.semicolon.lumexpress.service.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.websocket.server.ServerEndpoint;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmailDetails {
    private String userEmail;
    private  String mailContext;

}
