package com.example.productInventoryCRUD.Repositories;

import com.example.productInventoryCRUD.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductInventory extends JpaRepository<Product,Long> {

    public List<Product> findByDeletedFalse();


    public List<Product> findByPriceLessThanAndDeletedFalse(Double price);

    public Optional<Product> findByIdAndDeletedFalse(Long id);

    public boolean existsByIdAndDeletedFalse(Long id);


}
