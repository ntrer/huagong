package com.shushang.huagongproject.Bean;

import java.io.Serializable;

public class SalesOrderItemModel implements Serializable {


    //耐温性，CPC系列传递，S103系列传递
    public String TemperatureResistStr ;

    public String getTemperatureResistStr() {
        return TemperatureResistStr;
    }

    //剥离力，CPC系列传递
    public String PeelStrengthStr ;

    public String getPeelStrengthStr() {
        return PeelStrengthStr;
    }

    public void setPeelStrengthStr(String peelStrengthStr) {
        PeelStrengthStr = peelStrengthStr;
    }

    public String getMolecularWeightStr() {
        return MolecularWeightStr;
    }

    public void setMolecularWeightStr(String molecularWeightStr) {
        MolecularWeightStr = molecularWeightStr;
    }

    public String getSolidContentStr() {
        return SolidContentStr;
    }

    public void setSolidContentStr(String solidContentStr) {
        SolidContentStr = solidContentStr;
    }

    public String getLowBoilingContentStr() {
        return LowBoilingContentStr;
    }

    public void setLowBoilingContentStr(String lowBoilingContentStr) {
        LowBoilingContentStr = lowBoilingContentStr;
    }

    //分子量，S103系列传递
    public String MolecularWeightStr ;

    //固含量，CT919系列传递（%）
    public String SolidContentStr ;

    //低沸含量，S103系列传递（%）
    public String LowBoilingContentStr;


    public void setTemperatureResistStr(String temperatureResistStr) {
        TemperatureResistStr = temperatureResistStr;
    }

    public String getSpecId() {
        return SpecId;
    }

    public void setSpecId(String specId) {
        SpecId = specId;
    }



    public Double getCount() {
        return Count;
    }

    public void setCount(Double count) {
        Count = count;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public Double getItemTotalPrice() {
        return ItemTotalPrice;
    }

    public void setItemTotalPrice(Double itemTotalPrice) {
        ItemTotalPrice = itemTotalPrice;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    //规格ID
    public String SpecId;



    //数量（kg）
    public Double Count ;

    //单价
    public Double UnitPrice;

    //本项总价
    public Double ItemTotalPrice;

    //备注
    public String Note;
}
