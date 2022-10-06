package africa.semicolon.lumexpress.data.dto.request;

/*
public class UpdateCustomerDetails {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String imageUrl;
    }
 */

public record UpdateCustomerDetails(String customerId,String firstName, String lastName, String phoneNumber, String imageUrl) {
}

