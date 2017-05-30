package com.dultzdev.pointofsale.device.output;

import com.dultzdev.pointofsale.model.Product;
import com.dultzdev.pointofsale.model.PurchaseList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class PrinterTest {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(byteArrayOutputStream);
    private PrintStream oldPrintStream = System.out;

    @Before
    public void setUp() {
        System.setOut(printStream);
    }

    @After
    public void tearDown() {
        System.setOut(oldPrintStream);
    }
    @Test
    public void printBillTest() {
        Printer printer = new PrinterImpl();
        PurchaseList purchaseList = new PurchaseList();
        Product product1 = new Product(1, "First", "11", 3.53);
        Product product2 = new Product(2, "Second", "22", 4.47);
        Product product3 = new Product(3, "Third", "33", 2.21);
        purchaseList.addProduct(product1);
        purchaseList.addProduct(product2);
        purchaseList.addProduct(product3);
        printer.printBill(purchaseList);
        assertEquals(byteArrayOutputStream.toString(),
                 "1. " + product1.getName() + " - " + product1.getValue() + System.getProperty("line.separator") +
                        "2. " + product2.getName() + " - " + product2.getValue() + System.getProperty("line.separator") +
                        "3. " + product3.getName() + " - " + product3.getValue() + System.getProperty("line.separator") +
                        "TOTAL: " + (product1.getValue().add(product2.getValue()).add(product3.getValue())) + System.getProperty("line.separator"));
    }

}