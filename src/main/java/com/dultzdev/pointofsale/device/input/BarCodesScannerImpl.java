package com.dultzdev.pointofsale.device.input;


import com.dultzdev.pointofsale.exception.InvalidBarCodeException;
import com.dultzdev.pointofsale.exception.NotFoundException;
import com.dultzdev.pointofsale.model.Product;
import com.dultzdev.pointofsale.repository.ProductRepository;

public class BarCodesScannerImpl implements BarCodesScanner{
    private ProductRepository productRepository;

    public BarCodesScannerImpl(ProductRepository productRepository) {
        if(productRepository != null) {
            this.productRepository = productRepository;
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public Product scanProduct(String barcode) throws InvalidBarCodeException, NotFoundException {
        if(barcode != null) {
            return productRepository.findProductByBarcode(barcode);
        }
        else {
            throw new InvalidBarCodeException();
        }
    }
}
