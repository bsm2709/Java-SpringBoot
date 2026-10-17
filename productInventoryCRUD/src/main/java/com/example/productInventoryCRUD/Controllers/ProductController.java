package com.example.productInventoryCRUD.Controllers;

import com.example.productInventoryCRUD.Dtos.CreateProductDto.CreateProductRequestDto;
import com.example.productInventoryCRUD.Dtos.CreateProductDto.CreateProductResponseDto;
import com.example.productInventoryCRUD.Entity.Product;
import com.example.productInventoryCRUD.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<CreateProductResponseDto> createProduct( @RequestBody CreateProductRequestDto cprd){
        CreateProductResponseDto createdProduct = productService.createPro(cprd);

        if(createdProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(201).body(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> allActiveProducts(){
       List<Product> products =  productService.getAllProducts();
       if(products.isEmpty()){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/priceLessThan/{price}")
    public ResponseEntity<List<Product>> productLessThanGiven(@PathVariable Double price){
        List<Product> productsLessThan = productService.productLessThan(price);
        if(productsLessThan.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(productsLessThan);
    }
    @GetMapping("/price-less-than/{price}")
    public ResponseEntity<List<Product>> getCheapProducts(@PathVariable Double price) {
        List<Product> products = productService.productLessThan(price);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateProductResponseDto> singleActiveProduct(@PathVariable Long id){
        CreateProductResponseDto product = productService.getProduct(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateProductResponseDto> updateActiveProduct(@PathVariable Long id,
                                                                        @RequestBody CreateProductRequestDto cprd){
        CreateProductResponseDto updatedProduct = productService.updateProduct(id,cprd);
        if(updatedProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(201).body(updatedProduct);
    }

    @PatchMapping("/softDelete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Long id){
        boolean updatedProduct = productService.softlyDelete(id);
        if(!updatedProduct){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(201).body("Deleted Successfully");
    }
}
