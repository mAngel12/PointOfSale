package com.dultzdev.pointofsale.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class PurchaseListTest {

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    @Before
    public void setUp() {
        product1 = new Product(1, "First", "11", 3.53);
        product2 = new Product(2, "Second", "22", 4.47);
        product3 = new Product(3, "Third", "33", 2.21);
        product4 = new Product(4, "Fourth", "44", 5.99);

    }

    @Test
    public void addProductTest() {
        PurchaseList purchaseList = new PurchaseList();
        purchaseList.addProduct(product1);
        assertSame(purchaseList.getProducts().get(0), product1);
    }

    @Test
    public void getProductByIndexTest() {
        PurchaseList purchaseList = new PurchaseList();
        purchaseList.addProduct(product1);
        purchaseList.addProduct(product2);
        assertSame(purchaseList.getProductByIndex(1), product2);
    }

    @Test
    public void removeProductByBarcodeTest() {
        PurchaseList purchaseList = new PurchaseList();
        purchaseList.addProduct(product1);
        purchaseList.addProduct(product2);
        purchaseList.addProduct(product3);
        purchaseList.addProduct(product4);
        purchaseList.removeProductByBarcode("44");
        assertEquals(purchaseList.getProductsCost().toString(), "10.21");
    }


    @Test
    public void getProductsCostTest() {
        PurchaseList purchaseList = new PurchaseList();
        purchaseList.addProduct(product1);
        purchaseList.addProduct(product2);
        purchaseList.addProduct(product3);
        purchaseList.addProduct(product4);
        assertEquals(purchaseList.getProductsCost().toString(), "16.20");
    }

}