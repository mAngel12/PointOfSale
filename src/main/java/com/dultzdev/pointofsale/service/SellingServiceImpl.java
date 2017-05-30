package com.dultzdev.pointofsale.service;


import com.dultzdev.pointofsale.exception.InvalidBarCodeException;
import com.dultzdev.pointofsale.exception.NotFoundException;
import com.dultzdev.pointofsale.device.input.BarCodesScanner;
import com.dultzdev.pointofsale.device.output.LcdDisplay;
import com.dultzdev.pointofsale.device.output.Printer;
import com.dultzdev.pointofsale.model.Product;
import com.dultzdev.pointofsale.model.PurchaseList;

public class SellingServiceImpl implements SellingService {

    private BarCodesScanner barCodesScanner;
    private LcdDisplay lcdDisplay;
    private Printer printer;
    private PurchaseList purchaseList;

    public SellingServiceImpl(BarCodesScanner barCodesScanner, LcdDisplay lcdDisplay, Printer printer, PurchaseList purchaseList) {
        this.barCodesScanner = barCodesScanner;
        this.lcdDisplay = lcdDisplay;
        this.printer = printer;
        this.purchaseList = purchaseList;
    }

    @Override
    public void scan(String input) {
        if(input != "exit" && input != "EXIT") {
            try {
                Product product = barCodesScanner.scanProduct(input);
                purchaseList.addProduct(product);
                lcdDisplay.printElement(product);
            } catch (NotFoundException e) {
                lcdDisplay.printNotFound();
            } catch (InvalidBarCodeException e) {
                lcdDisplay.printInvalidBarCode();
            }

        } else {
            printer.printBill(purchaseList);
            lcdDisplay.printTotal(purchaseList);
        }
    }
}
