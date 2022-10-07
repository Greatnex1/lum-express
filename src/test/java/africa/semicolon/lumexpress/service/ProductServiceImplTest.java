package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dto.request.GetAllItemRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dto.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.exception.ProductNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.JsonPointerException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.RemoveOperation;
import com.github.fge.jsonpatch.ReplaceOperation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ProductServiceImplTest {
@Autowired
private ProductService productService;

private AddProductRequest request;

private AddProductResponse response;


    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("src/main/resources/image/milky.jpeg");
      MultipartFile file  = new MockMultipartFile("loyal",Files.readAllBytes(path));
        request =  AddProductRequest
                .builder()
                .name("loyal")
        .productCategory("BEVERAGES")
                .price(BigDecimal.valueOf(30.00))
                .quantity(10)
                .image(file)
                .build();
        response = productService.create(request);
    }

    @Test
    void addProduct() throws IOException {
      //AddProductResponse response = productService.create(request);
      assertThat(response).isNotNull();
      assertThat(response.getProductId()).isGreaterThan(0);
      assertThat(response.getMessage()).isNotNull();
      assertThat(response.getCode()).isEqualTo(201);


    }


    @Test
    void updateProductDetails() throws ProductNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        UpdateProductResponse updateResponse =null;
        try{
            JsonNode value = mapper.readTree("100.00");
         //   JsonNode value = mapper.readTree("\"eggs\"");
            JsonPatch patch = new JsonPatch(List.of(new ReplaceOperation(new JsonPointer("/price"),value)));
            // JsonPatch patch = new JsonPatch(List.of(new ReplaceOperation(new JsonPointer(""),value)));
            updateResponse = productService.updateProductDetails(1L, patch) ;
            log.info("updated product :: {}", updateResponse);
        }catch (Exception err){
            err.printStackTrace();
        }

//        UpdateProductRequest  updateProductRequest  = UpdateProductRequest
//                .builder()
//                .id(1L)
//                .price(BigDecimal.valueOf(300.00))
//                .description("nourishing and satisfying")
//                .quantity(2)
//                .build();
//       var updateResponse = productService.updateProductDetails(updateProductRequest);
       assertThat(updateResponse).isNotNull();
       assertThat(updateResponse.getStatusCode()).isEqualTo(200);
      assertThat(productService.getProductById(1L).getName()).isEqualTo("loyal");
    }

    @Test
    void getProductById() throws ProductNotFoundException, IOException {
      //  AddProductResponse response = productService.create(request);
        Product foundProduct = productService.getProductById(response.getProductId());
        assertThat(foundProduct).isNotNull();
        assertThat(foundProduct.getId()).isEqualTo(response.getProductId());
    }

    @Test
    void getAllProducts() throws IOException {
        productService.create(request);
        var getItemsRequest   = buildGetItemRequest();
        Page<Product> productPage =  productService.getAllProducts(getItemsRequest);
        log.info("page  contents  ::{}", productPage);
        assertThat(productPage).isNotNull();
        assertThat(productPage.getTotalElements()).isGreaterThan(0L);


    }

    private GetAllItemRequest buildGetItemRequest() {
        return GetAllItemRequest.builder().
                numberOfProductPerPage(8)
                        .pageNumber(1)
                .  build();
    }

    @Test
    void  deleteProduct(){

       assertThat(productService.deleteProduct(response.getProductId()));

    }


   /* private UpdateProductRequest buildUpdateRequest() {
        return UpdateProductRequest.builder()
                .price(BigDecimal.valueOf(40.00))
                .productId(1L)
                .description("its just milo")
                .quantity(10)
                .build();
                    }

                */

}