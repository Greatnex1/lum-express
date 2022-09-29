package africa.semicolon.lumexpress.data.dto.request;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter

public class AddProductRequest {
    private String name;
    private BigDecimal price;
    private   String productCategory;
    @NotNull
    private MultipartFile image;
    private int quantity;
}
