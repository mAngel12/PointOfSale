package com.dultzdev.pointofsale;


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
import com.dultzdev.pointofsale.service.SellingServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ApplicationExample {
    public static void main(String[] args) {

        Product product1 = new Product(1, "First", "11",3.53);
        Product product2 = new Product(2, "Second", "22", new BigDecimal(4.47));
        Product product3 = new Product(3, "Third", "33", 2.21);
        Product product4 = new Product(4, "Fourth", "44", new BigDecimal(5.99));

        List<Product> productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

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
        sellingService.scan("55");
        sellingService.scan("33");
        sellingService.scan("exit");
    }

}
