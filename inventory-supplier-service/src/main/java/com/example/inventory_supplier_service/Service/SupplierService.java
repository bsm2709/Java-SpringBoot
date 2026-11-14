package com.example.inventory_supplier_service.Service;

import com.example.inventory_supplier_service.Entity.Supplier;
import com.example.inventory_supplier_service.Repository.SupplierRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    SupplierRepo supplierRepo;

    public SupplierService(SupplierRepo supplierRepo){
        this.supplierRepo = supplierRepo;
    }

    //Add to db
    public Supplier addSupplierToDb(Supplier supplier){
        return  supplierRepo.save(supplier);
    }


    //Get All products from db;
    public List<Supplier> getAllSuppliersFromDb(){
        List<Supplier> suppliers = supplierRepo.findAll();
        return suppliers;
    }

    //Get product by id
    public Optional<Supplier> getProductFromDb(Long id){
        Optional<Supplier> supplier = supplierRepo.findById(id);
        return supplier;
    }


    //Update product
    @Transactional
    public Supplier updateSupplierToDb(Long id,Supplier supplier){
        Supplier originalSupplier = supplierRepo.findById(id).orElseThrow();

        originalSupplier.setName(supplier.getName());
        originalSupplier.setContactEmail(supplier.getContactEmail());


//        productRepo.flush();
        return  supplierRepo.save(originalSupplier);
    }

    //Delete Product
    @Transactional
    public Supplier deleteSupplierFromDb(Long id){
        Supplier deletedSupplier = supplierRepo.getReferenceById(id);
        supplierRepo.deleteById(id);
        return deletedSupplier;
    }


}
