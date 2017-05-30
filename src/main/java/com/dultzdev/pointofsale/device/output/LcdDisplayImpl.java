package com.dultzdev.pointofsale.device.output;


import com.dultzdev.pointofsale.model.Product;
import com.dultzdev.pointofsale.model.PurchaseList;

public class LcdDisplayImpl implements LcdDisplay {

    @Override
    public void printElement(Product product) {
        print(product.getName() + " - " + product.getValue());
    }

    @Override
    public void printNotFound() {
        print("Product not found");
    }

    @Override
    public void printInvalidBarCode() {
        print("Invalid bar-code");
    }

    @Override
    public void printTotal(PurchaseList purchaseList) {
        print("Total: " + purchaseList.getProductsCost() );
    }

    private void print(String text) {
        System.out.println(text);
    }
}
