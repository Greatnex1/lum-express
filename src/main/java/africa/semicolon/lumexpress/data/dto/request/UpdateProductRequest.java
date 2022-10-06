package africa.semicolon.lumexpress.data.dto.request;

import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
public class UpdateProductRequest {
    private Long productId;
private BigDecimal price;
private int quantity;
private String  description;
}
