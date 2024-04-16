package com.nc.nc.controller;

import com.nc.nc.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @Autowired
    private ExceptionService service;



    @GetMapping("/ari")
    public String arithmeticException(){
        return service.ariThmeticExeption();
    }
    @GetMapping("null-pointer")
    public String nullPointerException(){
        return service.nullPointerException();
    }
    @GetMapping("product")
    public String productException(){
        return service.productException();
    }
    @GetMapping("array")
    public String arrayOutOfBoundExeption(){
        return service.arrayOutOfBoundException();
    }
    @GetMapping("string")
    public String stringOutOfBoundExeption(){
        return service.stringOutOfBoundException();
    }
}
