package com.dultzdev.pointofsale.exception;


public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Product not found");
    }
}
