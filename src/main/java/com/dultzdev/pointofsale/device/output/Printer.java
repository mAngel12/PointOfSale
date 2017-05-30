package com.dultzdev.pointofsale.device.output;


import com.dultzdev.pointofsale.model.PurchaseList;

public interface Printer {

    void printBill(PurchaseList purchaseList);

}
