package com.dultzdev.pointofsale.device.output;


import com.dultzdev.pointofsale.model.Product;
import com.dultzdev.pointofsale.model.PurchaseList;

public interface LcdDisplay {

    void printElement(Product product);

    void printNotFound();

    void printInvalidBarCode();

    void printTotal(PurchaseList purchaseList);

}
