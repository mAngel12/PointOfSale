package com.dultzdev.pointofsale.device.input;


import com.dultzdev.pointofsale.exception.InvalidBarCodeException;
import com.dultzdev.pointofsale.exception.NotFoundException;
import com.dultzdev.pointofsale.model.Product;

public interface BarCodesScanner {

    Product scanProduct(String barcode) throws InvalidBarCodeException, NotFoundException;

}
