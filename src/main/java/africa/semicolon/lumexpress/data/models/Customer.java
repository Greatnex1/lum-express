package africa.semicolon.lumexpress.data.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Customer extends LumExpressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String firstname;
    @OneToOne
    private  Cart cart;
    private  Authority authority;
    @OneToMany(fetch=FetchType.EAGER)
    private Set <Address> address;
    private String imageUrl;
}
