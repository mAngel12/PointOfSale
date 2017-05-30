package com.dultzdev.pointofsale.repository;


import com.dultzdev.pointofsale.exception.NotFoundException;
import com.dultzdev.pointofsale.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> productList = new ArrayList<>();

    public ProductRepositoryImpl(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public Product findProductByBarcode(String barcode) throws NotFoundException {

        Product foundProduct = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getBarcode().equals(barcode)) {
                foundProduct = productList.get(i);
                break;
            }
        }

        if (foundProduct != null) {
            return foundProduct;
        } else {
            throw new NotFoundException();
        }
    }
}
