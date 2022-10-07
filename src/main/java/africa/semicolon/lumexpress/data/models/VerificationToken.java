package africa.semicolon.lumexpress.data.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    private String userEmail;
    private LocalDateTime createdAt = LocalDateTime.now();
    private  LocalDateTime expiresAt = createdAt.plusMinutes(10);

}
