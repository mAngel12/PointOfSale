package com.dultzdev.pointofsale.service;

import com.dultzdev.pointofsale.device.input.BarCodesScanner;
import com.dultzdev.pointofsale.device.input.BarCodesScannerImpl;
import com.dultzdev.pointofsale.device.output.LcdDisplay;
import com.dultzdev.pointofsale.device.output.LcdDisplayImpl;
import com.dultzdev.pointofsale.device.output.Printer;
import com.dultzdev.pointofsale.device.output.PrinterImpl;
import com.dultzdev.pointofsale.model.Product;
import com.dultzdev.pointofsale.model.PurchaseList;
import com.dultzdev.pointofsale.repository.ProductRepository;
import com.dultzdev.pointofsale.repository.ProductRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class SellingServiceTest {

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
    public void scanTest() {
        Product product1 = new Product(1, "First", "11",3.53);
        Product product2 = new Product(2, "Second", "22", new BigDecimal(4.47));
        Product product3 = new Product(3, "Third", "33", 2.21);

        List<Product> productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        ProductRepository productRepository = new ProductRepositoryImpl(productList);

        BarCodesScanner barCodesScanner = new BarCodesScannerImpl(productRepository);
        LcdDisplay lcdDisplay = new LcdDisplayImpl();
        Printer printer = new PrinterImpl();
        PurchaseList purchaseList = new PurchaseList();

        SellingServiceImpl sellingService = new SellingServiceImpl(barCodesScanner, lcdDisplay, printer, purchaseList);
        sellingService.scan("11");
        sellingService.scan("44");
        sellingService.scan(null);
        sellingService.scan("22");
        sellingService.scan("33");
        sellingService.scan("exit");

        assertEquals(byteArrayOutputStream.toString(),
                product1.getName() + " - " + product1.getValue() + System.getProperty("line.separator") +
                        "Product not found" + System.getProperty("line.separator") +
                        "Invalid bar-code" + System.getProperty("line.separator") +
                        product2.getName() + " - " + product2.getValue()+ System.getProperty("line.separator") +
                        product3.getName() + " - " + product3.getValue() + System.getProperty("line.separator") +
                        "1. " + product1.getName() + " - " + product1.getValue() + System.getProperty("line.separator") +
                        "2. " + product2.getName() + " - " + product2.getValue() + System.getProperty("line.separator") +
                        "3. " + product3.getName() + " - " + product3.getValue() + System.getProperty("line.separator") +
                        "TOTAL: " + (product1.getValue().add(product2.getValue()).add(product3.getValue())) + System.getProperty("line.separator") +
                        "Total: " + (product1.getValue().add(product2.getValue()).add(product3.getValue())) + System.getProperty("line.separator"));
    }

}