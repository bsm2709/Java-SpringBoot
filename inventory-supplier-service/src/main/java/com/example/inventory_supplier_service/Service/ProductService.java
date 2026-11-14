package com.example.inventory_supplier_service.Service;

import com.example.inventory_supplier_service.Entity.Product;
import com.example.inventory_supplier_service.Repository.ProductRepo;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    //Add to db
    public Product addProductToDb(Product product){
        return  productRepo.save(product);
    }

    //Get All products from db;
    public List<Product> getAllProductsFromDb(int page, int size, String sortBy) {

        Sort sort = Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> productPage = productRepo.findAll(pageable);
        return productPage.getContent();
    }

    //Check Threshold
    public List<Product> getAccordingToThreshold(Long supplierId, int value){
        List<Product> products = productRepo.findBySupplier_IdAndStockQuantityLessThan(supplierId, value);
        return products;
    }

    //Get product by id
    public Optional<Product> getProductFromDb(Long id){
        Optional<Product> products = productRepo.findById(id);
        return products;
    }



    //Update product
    @Transactional
    public Product updateProductToDb(Long id,Product product){
        Product originalProduct = productRepo.findById(id).orElseThrow();

        originalProduct.setName(product.getName());
        originalProduct.setPrice(product.getPrice());
        originalProduct.setStockQuantity(product.getStockQuantity());
        originalProduct.setSupplier(product.getSupplier());

//        productRepo.flush();
        return  productRepo.save(originalProduct);
    }

    //Delete Product
    @Transactional
    public Product deleteProductFromDb(Long id){
        Product deletedProduct = productRepo.getReferenceById(id);
        productRepo.deleteById(id);
        return deletedProduct;
    }
}
