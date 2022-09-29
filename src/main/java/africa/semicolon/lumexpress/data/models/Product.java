package africa.semicolon.lumexpress.data.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String name;
    private  String description;
    private BigDecimal price;
    private int quantity;
    @ElementCollection
    private List<Category> categories = new ArrayList<>();
    private String image;

}
