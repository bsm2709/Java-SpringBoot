package com.example.inventory_supplier_service.Controller;

import com.example.inventory_supplier_service.Entity.Product;
import com.example.inventory_supplier_service.Service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product product1 = productService.addProductToDb(product);

        return  ResponseEntity.ok(product1);
    }


    @GetMapping("/{page}/{size}/{id}")
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Product> productList = productService.getAllProductsFromDb(page, size, sortBy);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/threshold/{supplierId}/{value}")
    public ResponseEntity<List<Product>> getLowProducts(@PathVariable Long supplierId,
                                                        @PathVariable int value){
        List<Product> products = productService.getAccordingToThreshold(supplierId, value);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long id){
        Optional<Product> productList = productService.getProductFromDb(id);

        return ResponseEntity.ok(productList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                 @RequestBody Product product){
        Product updatedProduct = productService.updateProductToDb(id,product);

        return  ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        Product product1 = productService.deleteProductFromDb(id);

        return  ResponseEntity.ok(product1);
    }
}
