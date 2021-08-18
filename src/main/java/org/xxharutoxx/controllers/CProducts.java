package org.xxharutoxx.controllers;

import org.xxharutoxx.models.Products;

import java.sql.Date;
import java.util.List;

public class CProducts {
    public static Products createProduct(String name_product,String mark, Integer stock, double price,String category){
        Products create=new Products();
        create.setName_product(name_product);
        create.setMark(mark);
        create.setStock(stock);
        create.setPrice(price);
        create.setCategory(category);
        return create;
    }
    public static List<Products> CListProducts(){return Products.getProducts();}
    public static Products CGetLastProduct(){return Products.getLastProduct();}
    public static Products CUpdateStockProductFromCancel(int id_product,int stock){
        Products update=new Products();
        update.setId_product(id_product);
        update.setStock(stock);
        return update;
    }
}
