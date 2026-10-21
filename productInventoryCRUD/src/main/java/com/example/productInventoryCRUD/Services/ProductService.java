package com.example.productInventoryCRUD.Services;

import com.example.productInventoryCRUD.Dtos.CreateProductDto.CreateProductRequestDto;
import com.example.productInventoryCRUD.Dtos.CreateProductDto.CreateProductResponseDto;
import com.example.productInventoryCRUD.Entity.Product;
import com.example.productInventoryCRUD.ExceptionHandling.ItemNotFound;
import com.example.productInventoryCRUD.Repositories.ProductInventory;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    ProductInventory productInventory;
    public ProductService(ProductInventory productInventory){
        this.productInventory = productInventory;
    }

    //Create Products
    public CreateProductResponseDto createPro(CreateProductRequestDto product){
        //Converted RequestDto to Product
        Product createdProduct = createRequestDtoToProduct(product);
        //Saved Product to Database
        Product createdProduct1 = productInventory.save(createdProduct);
        //Now convert the Product back to ResponseDto

        return productToCreateResponseDto(createdProduct1);
    }

    //Get all products
    public List<Product> getAllProducts(){
        return productInventory.findByDeletedFalse();
    }

    //Get products less than given
    public List<Product> productLessThan(Double price){
        return productInventory.findByPriceLessThanAndDeletedFalse(price);
    }


    //Get perticular product
    public CreateProductResponseDto getProduct(Long id){
        Product product = productInventory.findByIdAndDeletedFalse(id).orElseThrow(() -> new ItemNotFound("id of "+ id + " not found " ));

        //Convert to ResponseDto
        return productToCreateResponseDto(product);
    }

    //Update Product
    public CreateProductResponseDto updateProduct(Long id,CreateProductRequestDto cprd){
        //Convert to product
        Product product = createRequestDtoToProduct(cprd);

        //Update
        Product updateProduct = productInventory.findByIdAndDeletedFalse(id).orElseThrow(() -> new ItemNotFound("id of "+ id + " not found t perform update" ));

        updateProduct.setProductName(product.getProductName());
        updateProduct.setQuantity(product.getQuantity());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setDeleted(false);
        updateProduct.setUpdatedAt(String.valueOf(LocalDateTime.now()));

        productInventory.save(updateProduct);

        //Convert Product to response dto
        return productToCreateResponseDto(updateProduct);
    }


    //Soft-Delete
    public void softlyDelete(Long id){
        boolean isPresent = productInventory.existsByIdAndDeletedFalse(id);

        Product deletedProduct = productInventory.findByIdAndDeletedFalse(id).orElseThrow(() -> new ItemNotFound("id of "+ id + " not found to delete" ));

        //Edit its setDeleted to true
        deletedProduct.setDeleted(true);

        productInventory.save(deletedProduct);
    }



    //Methods for Mapping

    public Product createRequestDtoToProduct(CreateProductRequestDto cprd){
        Product product = new Product();

        //Assignment
        product.setProductName(cprd.getProductName());
        product.setPrice(cprd.getPrice());
        product.setQuantity(cprd.getQuantity());

        //Declaring Deleted here only
        product.setDeleted(false);

        //Giving timeline
        product.setCreatedAt(String.valueOf(LocalDateTime.now()));
        product.setUpdatedAt(String.valueOf(LocalDateTime.now()));

        //Return Product object
        return product;
    }

    public CreateProductResponseDto productToCreateResponseDto(Product product){
        CreateProductResponseDto cpred = new CreateProductResponseDto();

        //Assignment
        cpred.setProductName(product.getProductName());
        cpred.setId(product.getId());
        cpred.setPrice(product.getPrice());
        cpred.setQuantity(product.getQuantity());
        cpred.setCreatedAt(LocalDateTime.parse(product.getCreatedAt()));
        cpred.setUpdatedAt(LocalDateTime.parse(product.getUpdatedAt()));

        return cpred;

    }
}
