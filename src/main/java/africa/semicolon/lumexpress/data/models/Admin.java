package africa.semicolon.lumexpress.data.models;

import africa.semicolon.lumexpress.LumExpressApplication;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Admin extends LumExpressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    @ElementCollection
    private Set<Authority> authorities;
}
