package com.dultzdev.pointofsale.repository;

import com.dultzdev.pointofsale.exception.NotFoundException;
import com.dultzdev.pointofsale.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductRepositoryTest {

    private Product product1;
    private Product product2;
    private List<Product> productList = new ArrayList<>();

    @Before
    public void setUp() {
        product1 = new Product(1, "First", "11", 3.53);
        product2 = new Product(2, "Second", "22", 4.47);
        productList.add(product1);
        productList.add(product2);
    }

    @Test
    public void findProductByBarcodeTest() throws NotFoundException {
        ProductRepository productRepository = new ProductRepositoryImpl(productList);
        assertSame(productRepository.findProductByBarcode("22"), product2);
    }

    @Test(expected = NotFoundException.class)
    public void findProductByBarcodeNotFoundExceptionTest() throws NotFoundException {
        ProductRepository productRepository = new ProductRepositoryImpl(productList);
        productRepository.findProductByBarcode("33");
    }

}