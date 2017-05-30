package com.dultzdev.pointofsale.repository;


import com.dultzdev.pointofsale.exception.NotFoundException;
import com.dultzdev.pointofsale.model.Product;

public interface ProductRepository {

    Product findProductByBarcode(String barcode) throws NotFoundException;

}
