package com.dultzdev.pointofsale.model;


import java.math.BigDecimal;

public class Product {

    private Integer id;
    private String name;
    private String barcode;
    private BigDecimal value;

    public Product(Integer id, String name, String barcode, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.value = value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public Product(Integer id, String name, String barcode, double value) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
