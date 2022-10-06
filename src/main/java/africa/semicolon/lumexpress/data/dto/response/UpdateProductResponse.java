package africa.semicolon.lumexpress.data.dto.response;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UpdateProductResponse {
    private String message;
    private int  statusCode;
    private  String productName;
    private  String description;
    private double price;
}
