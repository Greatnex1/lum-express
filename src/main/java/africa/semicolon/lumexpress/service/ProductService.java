package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dto.request.GetAllItemRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dto.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.exception.ProductNotFoundException;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    AddProductResponse create(AddProductRequest createProductRequest) throws  IOException;
    UpdateProductResponse updateProductDetails(UpdateProductRequest updateProductRequest) throws ProductNotFoundException;
    Product getProductById(Long id) throws ProductNotFoundException;
    Page<Product> getAllProducts(GetAllItemRequest  getAllItemRequest);

    Page<Product> getAllProducts();

    String deleteProduct(Long  id);


}
