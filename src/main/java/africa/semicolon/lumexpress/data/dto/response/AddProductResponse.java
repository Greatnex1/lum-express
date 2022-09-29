package africa.semicolon.lumexpress.data.dto.response;

import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter

public class AddProductResponse {
    private Long productId;
    private int code;
    private String message;

}
