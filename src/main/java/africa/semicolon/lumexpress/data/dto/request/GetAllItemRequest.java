package africa.semicolon.lumexpress.data.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllItemRequest {
    private   int numberOfProductPerPage;
    private int  pageNumber;
}
