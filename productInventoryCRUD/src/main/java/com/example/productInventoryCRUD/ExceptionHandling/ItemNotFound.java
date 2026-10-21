package com.example.productInventoryCRUD.ExceptionHandling;

import org.springframework.stereotype.Component;

public class ItemNotFound extends RuntimeException{
    public ItemNotFound(String msg){
        super(msg);
    }
}
