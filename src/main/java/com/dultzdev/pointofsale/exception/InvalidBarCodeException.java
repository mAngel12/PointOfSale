package com.dultzdev.pointofsale.exception;


public class InvalidBarCodeException extends Exception {
    public InvalidBarCodeException() {
        super("Invalid bar-code");
    }
}
