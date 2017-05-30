package com.dultzdev.pointofsale.device.input;

import com.dultzdev.pointofsale.exception.InvalidBarCodeException;
import com.dultzdev.pointofsale.exception.NotFoundException;
import com.dultzdev.pointofsale.model.Product;
import com.dultzdev.pointofsale.repository.ProductRepository;
import com.dultzdev.pointofsale.repository.ProductRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class BarCodesScannerTest {

    private Product product1;
    private Product product2;
    private List<Product> productList = new ArrayList<>();
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        product1 = new Product(1, "First", "11", 3.53);
        product2 = new Product(2, "Second", "22", 4.47);
        productList.add(product1);
        productList.add(product2);
        productRepository = new ProductRepositoryImpl(productList);
    }

    @Test
    public void scanProductTest() throws InvalidBarCodeException, NotFoundException {
        BarCodesScanner barCodesScanner = new BarCodesScannerImpl(productRepository);
        assertEquals(barCodesScanner.scanProduct("22"), product2);

    }

    @Test(expected = InvalidBarCodeException.class)
    public void scanProductInvalidBarCodeExceptionTest() throws InvalidBarCodeException, NotFoundException {
        BarCodesScanner barCodesScanner = new BarCodesScannerImpl(productRepository);
        barCodesScanner.scanProduct(null);
    }
}