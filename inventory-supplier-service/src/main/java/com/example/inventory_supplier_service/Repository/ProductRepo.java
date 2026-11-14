package com.example.inventory_supplier_service.Repository;

import com.example.inventory_supplier_service.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product>  findBySupplier_IdAndStockQuantityLessThan(Long supplierId, int threshold);

}
