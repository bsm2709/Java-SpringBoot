package com.example.inventory_supplier_service.Controller;

import com.example.inventory_supplier_service.Entity.Supplier;
import com.example.inventory_supplier_service.Service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    SupplierService supplierService;

    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }



    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier){
        Supplier supplier1 = supplierService.addSupplierToDb(supplier);

        return  ResponseEntity.ok(supplier1);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        List<Supplier> suppliers = supplierService.getAllSuppliersFromDb();

        return ResponseEntity.ok(suppliers);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Supplier>> getSupplier(@PathVariable Long id){
        Optional<Supplier> supplier = supplierService.getProductFromDb(id);

        return ResponseEntity.ok(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id,
                                                 @RequestBody Supplier supplier){
        Supplier updatedSupplier = supplierService.updateSupplierToDb(id,supplier);

        return  ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable Long id){
        Supplier product1 = supplierService.deleteSupplierFromDb(id);

        return  ResponseEntity.ok(product1);
    }

}
