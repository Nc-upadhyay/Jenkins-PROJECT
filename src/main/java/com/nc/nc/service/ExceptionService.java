package com.nc.nc.service;

import com.nc.nc.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {
    public String ariThmeticExeption() {
        int a = 10 / 0;
        return "This is Arithmetic exception";
    }

    public String arrayOutOfBoundException() {
        int ar[] = new int[2];
        System.out.println(ar[3]);
        return "This is Array Out Of Bound exception";
    }

    public String stringOutOfBoundException() {
        String ar = "this";
        System.out.println(ar.charAt(5));
        return "This is String Out Of Bound exception";
    }

    public String nullPointerException() {
        String ar = null;
        System.out.println(ar.length());
        return "This is null pointer exception";
    }
    public String productException(){
        throw new ProductNotFoundException("This is product not found custom exception");
    }
}
