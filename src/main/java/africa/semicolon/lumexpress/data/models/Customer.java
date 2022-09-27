package africa.semicolon.lumexpress.data.models;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends LumExpressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @OneToOne

    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private  Cart cart;
    @OneToMany(fetch=FetchType.EAGER)

    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Set <Address> addresses =  new HashSet<>();

}
