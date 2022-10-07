package africa.semicolon.lumexpress.data.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LumExpressUser extends Admin  {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private  String imageUrl;
    private boolean isEnabled;

}
