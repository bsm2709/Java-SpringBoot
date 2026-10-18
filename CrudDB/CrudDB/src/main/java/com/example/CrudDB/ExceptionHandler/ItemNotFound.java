package com.example.CrudDB.ExceptionHandler;

public class ItemNotFound extends RuntimeException{
    public ItemNotFound(String msg){
        super(msg);
    }
}
