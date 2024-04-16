package com.nc.nc.exception;

public class ProductNotFoundException extends RuntimeException{
    String msg;
    public ProductNotFoundException(String msg)
    {
        this.msg=msg;
    }

}
