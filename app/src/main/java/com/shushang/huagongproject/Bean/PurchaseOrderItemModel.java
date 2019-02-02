package com.shushang.huagongproject.Bean;

import java.io.Serializable;

public class PurchaseOrderItemModel implements Serializable {
    private int Count ;
    private double UnitPrice  ;
    private String MaterielName ;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public String getMaterielName() {
        return MaterielName;
    }

    public void setMaterielName(String materielName) {
        MaterielName = materielName;
    }

    public String getSpecificationName() {
        return SpecificationName;
    }

    public void setSpecificationName(String specificationName) {
        SpecificationName = specificationName;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getPaymentTerm() {
        return PaymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        PaymentTerm = paymentTerm;
    }

    private String SpecificationName  ;
    private String SupplierName  ;
    private String PaymentTerm  ;
}
