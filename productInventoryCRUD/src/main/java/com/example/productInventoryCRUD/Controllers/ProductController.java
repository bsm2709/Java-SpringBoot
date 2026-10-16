package com.example.productInventoryCRUD.Controllers;

import com.example.productInventoryCRUD.Entity.Product;
import com.example.productInventoryCRUD.Services.ProductService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product createdProduct = productService.createPro(product);

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
    public ResponseEntity<Optional<Product>> singleActiveProduct(@PathVariable Long id){
        Optional<Product> product = productService.getProduct(id);
        if(product.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateActiveProduct(@PathVariable Long id,
                                    @RequestBody Product product){
        Product updatedProduct = productService.updateProduct(id,product);
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
