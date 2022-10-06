package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dto.request.GetAllItemRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dto.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.models.Category;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.exception.ProductNotFoundException;
import africa.semicolon.lumexpress.repository.ProductRepository;
import africa.semicolon.lumexpress.service.cloud.CloudService;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    private final CloudService cloudService;
    private ObjectMapper oMapper;

    @Override
    public AddProductResponse create(AddProductRequest createProductRequest) throws IOException {
        Product  product = mapper.map(createProductRequest, Product.class);
        product.getCategories().add(Category.valueOf(createProductRequest.getProductCategory().toUpperCase()));
       var imageUrl =   cloudService.upload(createProductRequest.getImage().getBytes(),ObjectUtils.emptyMap());
        product.setImageUrl(imageUrl);
        var savedProduct = productRepository.save(product);
        log.info("cloudinary image url :: {}", imageUrl);
        log.info("product saved to db::{}", savedProduct);
        return buildCreateProductResponse(savedProduct);
    }

    private AddProductResponse buildCreateProductResponse(Product savedProduct) {
        return AddProductResponse
                .builder()
                .productId(savedProduct.getId())
                .code(201)
                .message(savedProduct.getName() + "added products")
                .build();
    }

    @Override
    public UpdateProductResponse updateProductDetails(Long productId, JsonPatch patch) throws ProductNotFoundException {
        var foundProduct =   productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(
                String.format("product with id %d not found", productId)

        ));
//        foundProduct.setPrice(productId);
//        foundProduct.setQuantity(productId);
        Product updateProduct = applyPatchToProduct(patch, foundProduct);
        var savedProduct = productRepository.save(updateProduct);
        return  buildUpdateResponse(savedProduct);
    }

    private UpdateProductResponse buildUpdateResponse(Product savedProduct) {
        return UpdateProductResponse
                .builder()
                .productName(savedProduct.getName())
                .price(savedProduct.getPrice())
                .statusCode(200)
                .message("updated successfully")
                .build();


    }

    private Product applyPatchToProduct(JsonPatch patch, Product foundProduct) {
        JsonNode productNode = oMapper.convertValue(foundProduct,JsonNode.class);
        JsonNode patchedProductNode;
        try{
            patchedProductNode = patch.apply(productNode);
            return oMapper.readValue(oMapper.writeValueAsString(patchedProductNode),
                    Product.class);
        }catch(JsonPatchException|IOException  err){
            err.printStackTrace();
            return  foundProduct;
        }

    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() ->
                new ProductNotFoundException(String.format("product with id %d not found", id)));
    }

    @Override
    public Page<Product> getAllProducts(GetAllItemRequest getAllItemRequest) {
        Pageable pageSpecs = PageRequest.of(getAllItemRequest.getPageNumber() -1,getAllItemRequest.getNumberOfProductPerPage());
        return productRepository.findAll(pageSpecs);
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}

