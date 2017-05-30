package com.dultzdev.pointofsale.device.output;


import com.dultzdev.pointofsale.model.PurchaseList;

public class PrinterImpl implements Printer {

    @Override
    public void printBill(PurchaseList purchaseList) {
        for(int i = 0; i < purchaseList.getProducts().size(); i++)
        {
            print(i+1 + ". " + purchaseList.getProductByIndex(i).getName() + " - " + purchaseList.getProductByIndex(i).getValue());
        }

        print("TOTAL: " + purchaseList.getProductsCost());

    }

    private void print(String text) {
        System.out.println(text);
    }
}
