package com.example.productInventoryCRUD.Dtos.CreateProductDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateProductRequestDto {


    @NotBlank(message = "Name cant be black/empty/null")
    private String productName;

    @Min(value = 0, message = "price cant be negative")
    private Double price;

    @Min(value = 0, message = "Quantity cant be negative")
    private Integer quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
