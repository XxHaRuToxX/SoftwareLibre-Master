package org.xxharutoxx.controllers;

import org.xxharutoxx.models.ReceptionStock;

import java.util.List;

public class CReceptionStock {
    public static ReceptionStock CReceptionProduct(int quantity, boolean state, String nameProduct){
        ReceptionStock saveReception=new ReceptionStock();
        saveReception.setQuantity(quantity);
        saveReception.setState(state);
        saveReception.setName_product(nameProduct);
        return saveReception;
    }
    public static List<ReceptionStock> CGetReceptionStock(){
        ReceptionStock receptionStock=new ReceptionStock();
        return receptionStock.getReceptionStock();
    }
    public static ReceptionStock CUpdateStockProductFromReception(int quantity,String nameProduct){
        ReceptionStock updateReception=new ReceptionStock();
        updateReception.setQuantity(quantity);
        updateReception.setName_product(nameProduct);
        return updateReception;
    }
    public static ReceptionStock CGetLastReceptionStock(){return ReceptionStock.getLastReceptionStock();}
}
