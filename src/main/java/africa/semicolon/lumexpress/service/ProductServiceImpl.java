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
    private final ModelMapper mapper = new ModelMapper();

    private final CloudService cloudService;

    @Override
    public AddProductResponse create(AddProductRequest createProductRequest) throws IOException {
        Product product = mapper.map(createProductRequest, Product.class);
        product.getCategories().add(Category.valueOf(createProductRequest.getProductCategory().toUpperCase()));
        var imageUrl = cloudService.upload(createProductRequest.getImage().getBytes(), ObjectUtils.emptyMap());
        product.setImage(imageUrl);
        var savedProduct = productRepository.save(product);
        log.info("cloudinary image url :: {}", imageUrl);
        return buildCreateProductResponse(savedProduct);
    }

    private AddProductResponse buildCreateProductResponse(Product savedProduct) {
        return AddProductResponse.builder()
                .code(201)
                .productId(savedProduct.getId())
                .message("product added successfully")
                .build();
    }

    @Override
    public UpdateProductResponse updateProductDetails(UpdateProductRequest updateProductRequest) throws ProductNotFoundException {
        var foundProduct  =   productRepository.findById(updateProductRequest.getId()).orElseThrow(
                () ->   new ProductNotFoundException(String.format( "product with id %d  not found", updateProductRequest.getId()))
        );
        foundProduct.setName("");
                return null;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        //
        //  if (foundProduct.isPresent()) return foundProduct.get();
        //  throw new ProductNotFoundException(
        //        String.format("product with id %d not found", id)
        //  );

        return productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(
                        String.format("product with id %d not found", id)));


    }

    @Override
    public Page<Product> getAllProducts(GetAllItemRequest getAllItemRequest) {
        Pageable pageSpecs = PageRequest.of(getAllItemRequest.getPageNumber(), getAllItemRequest.getNumberOfProductPerPage());
        Page<Product> products = productRepository.findAll(pageSpecs);

        return products;

    }
    @Override
    public Page<Product> getAllProducts() {

        Pageable pageSpecs = PageRequest.of(0, 5);
        productRepository.findAll(pageSpecs);

        return null;
    }

   @Override
    public String deleteProduct(Long id) {
       return null;
    }
}
