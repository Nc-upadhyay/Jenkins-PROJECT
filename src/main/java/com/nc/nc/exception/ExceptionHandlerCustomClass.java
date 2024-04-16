package com.nc.nc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerCustomClass {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> ariThmeticException(ArithmeticException exception) {
        return new ResponseEntity("Arithmetic -- exception" + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> nullException(NullPointerException exception) {
        return new ResponseEntity("Null Pointer -- exception" + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<?> array(ArrayIndexOutOfBoundsException exception) {
        return new ResponseEntity("ArrayIndexOutOfBoundsException -- exception" + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public ResponseEntity<?> string(StringIndexOutOfBoundsException exception) {
        return new ResponseEntity("StringIndexOutOfBoundsException -- exception" + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> string(ProductNotFoundException exception) {
        return new ResponseEntity("ProductNotFoundException -- exception" + exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
