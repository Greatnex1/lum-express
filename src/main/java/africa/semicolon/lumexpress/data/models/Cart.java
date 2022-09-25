package africa.semicolon.lumexpress.data.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List <Item> items;
}
