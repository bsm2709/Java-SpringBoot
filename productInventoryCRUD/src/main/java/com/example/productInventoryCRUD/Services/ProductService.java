package com.example.productInventoryCRUD.Services;

import com.example.productInventoryCRUD.Dtos.CreateProductDto.CreateProductRequestDto;
import com.example.productInventoryCRUD.Dtos.CreateProductDto.CreateProductResponseDto;
import com.example.productInventoryCRUD.Entity.Product;
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
        CreateProductResponseDto cpred = productToCreateResponseDto(createdProduct1);

        return cpred;
    }

    //Get all products
    public List<Product> getAllProducts(){
        List<Product> products = productInventory.findByDeletedFalse();
        return products;
    }

    //Get products less than given
    public List<Product> productLessThan(Double price){
        List<Product> products = productInventory.findByPriceLessThanAndDeletedFalse(price);
        return products;
    }


    //Get perticular product
    public CreateProductResponseDto getProduct(Long id){
        Product product = productInventory.findByIdAndDeletedFalse(id);

        //Convert to ResponseDto
        CreateProductResponseDto cpred = productToCreateResponseDto(product);
        return cpred;
    }

    //Update Product
    public CreateProductResponseDto updateProduct(Long id,CreateProductRequestDto cprd){
        //Convert to product
        Product product = createRequestDtoToProduct(cprd);
        boolean isPresent = productInventory.existsByIdAndDeletedFalse(id);
        if(!isPresent){
            return null;
        }
        Product updateProduct = productInventory.getReferenceById(id);

        updateProduct.setProductName(product.getProductName());
        updateProduct.setQuantity(product.getQuantity());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setDeleted(false);
        updateProduct.setUpdatedAt(String.valueOf(LocalDateTime.now()));

        productInventory.save(updateProduct);

        //Convert Product to response dto
        CreateProductResponseDto cpred = productToCreateResponseDto(updateProduct);
        return cpred;
    }


    //Soft-Delete
    public boolean softlyDelete(Long id){
        boolean isPresent = productInventory.existsByIdAndDeletedFalse(id);
        if(!isPresent){
            return false;
        }
        Product deletedProduct = productInventory.getReferenceById(id);
        deletedProduct.setDeleted(true);

        productInventory.save(deletedProduct);
        return true;
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
