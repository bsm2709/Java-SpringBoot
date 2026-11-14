package com.example.inventory_supplier_service.Repository;

import com.example.inventory_supplier_service.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Long> {
}
