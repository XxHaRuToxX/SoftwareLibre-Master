package org.xxharutoxx.controllers;

import org.xxharutoxx.models.OutputProduct;

public class COutputProduct {
    public static OutputProduct CCreateOutputProduct( String user_output){
        OutputProduct createOutput=new OutputProduct();
        createOutput.setUser_output(user_output);;
        return createOutput;
    }
    public static OutputProduct CDeleteOutputProduct(int id_product){
        OutputProduct productOut=new OutputProduct();
        productOut.setId_outputProduct(id_product);
        return productOut;
    }
}
