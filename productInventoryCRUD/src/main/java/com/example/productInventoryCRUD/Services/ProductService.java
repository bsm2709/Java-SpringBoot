package com.example.productInventoryCRUD.Services;

import com.example.productInventoryCRUD.Entity.Product;
import com.example.productInventoryCRUD.Repositories.ProductInventory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    ProductInventory productInventory;
    public ProductService(ProductInventory productInventory){
        this.productInventory = productInventory;
    }

    //Create Products
    public Product createPro(Product product){
        product.setDeleted(false);
        Product createdProduct = productInventory.save(product);
        return createdProduct;
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
    public Optional<Product> getProduct(Long id){
        Optional<Product> product = productInventory.findByIdAndDeletedFalse(id);
        return product;
    }

    //Update Product
    public Product updateProduct(Long id,Product product){
        boolean isPresent = productInventory.existsByIdAndDeletedFalse(id);
        if(!isPresent){
            return null;
        }
        Product updateProduct = productInventory.getReferenceById(id);

        updateProduct.setProductName(product.getProductName());
        updateProduct.setQuantity(product.getQuantity());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setDeleted(false);

//        productInventory.save(updateProduct);
        return updateProduct;
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


}
