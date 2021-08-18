package org.xxharutoxx.controllers;

import org.xxharutoxx.models.DescOutputProduct;
import org.xxharutoxx.models.Products;

public class CDescOutputProduct {
    public static DescOutputProduct CCreateDescOutputProduct(String nameProduct,Integer quantity_desc,Integer id_output, Integer id_product){
        DescOutputProduct descOutputProduct=new DescOutputProduct();
        descOutputProduct.setName_product(nameProduct);
        descOutputProduct.setQuantity_product(quantity_desc);
        descOutputProduct.setId_outputProduct(id_output);
        descOutputProduct.setId_product(id_product);
        return  descOutputProduct;
    }
    public static  DescOutputProduct CUpdateStockProduct(int quantity, int id_product){
        DescOutputProduct updateStockProduct=new DescOutputProduct();
        updateStockProduct.setQuantity_product(quantity);
        updateStockProduct.setId_product(id_product);
        return updateStockProduct;
    }
    public static DescOutputProduct CDeleteDescOutputProduct(int id_desc){
        DescOutputProduct productDesc=new DescOutputProduct();
        productDesc.setId_outputProduct(id_desc);
        return productDesc;
    }

}
