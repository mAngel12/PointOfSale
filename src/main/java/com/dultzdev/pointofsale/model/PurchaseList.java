package com.dultzdev.pointofsale.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseList {

    private List<Product> purchaseList = new ArrayList<Product>();

    public PurchaseList() { }

    public void addProduct(Product product) {
        if(product != null) {
            purchaseList.add(product);
        }
        else {
            throw new NullPointerException();
        }
    }

    public void removeProductByBarcode(String barcode) {
        for(int i = 0; i < purchaseList.size(); i++) {
            if(purchaseList.get(i).getBarcode().equals(barcode)) {
                purchaseList.remove(i);
            }
        }
    }

    public Product getProductByIndex(int index) {
        return purchaseList.get(index);
    }
    public List<Product> getProducts() {
        return purchaseList;
    }

    public BigDecimal getProductsCost() {
        BigDecimal cost = new BigDecimal(0);

        for(Product product : purchaseList) {
            cost = cost.add(product.getValue());
        }

        return cost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}
