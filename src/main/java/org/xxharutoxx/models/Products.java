package org.xxharutoxx.models;

import org.xxharutoxx.connection.ConnectionSQlite;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Products extends ConnectionSQlite {

    private Integer id_product;
    private String name_product;
    private String mark;
    private Integer stock;
    private double price;
    private String category;
    private String date_in;

    public Products() {
    }

    public Products(Integer id_product, String name_product, String mark, Integer stock, double price, String category, String date_in) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.mark = mark;
        this.stock = stock;
        this.price = price;
        this.category = category;
        this.date_in=date_in;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public boolean createProduct(){
        try{
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date=new Date();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            openConexion();

            consulta=conexion.prepareStatement("insert into product_tbl (name_product, mark, stock, price,category,date_in) values (?,?,?,?,?,?)");
            consulta.setString(1,getName_product());
            consulta.setString(2,getMark());
            consulta.setInt(3,getStock());
            consulta.setDouble(4,getPrice());
            consulta.setString(5,getCategory());
            consulta.setString(6,String.valueOf(sqlDate));
//            Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())))
            return consulta.execute();

        }catch (Exception ex){

        }finally {
            closeConexion();
        }
        return true;
    }
    public boolean updateStockProductCancel(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("update product_tbl set stock =(product_tbl.stock + ?) where id_product =?");
            consulta.setInt(1,getStock());
            consulta.setInt(2,getId_product());
            return consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }
    public static List<Products> getProducts(){
        List<Products> ListProducts=new ArrayList<>();
        try{
            openConexion();
            consulta=conexion.prepareStatement("select*from product_tbl");
            resultado=consulta.executeQuery();
            while (resultado.next()) {
                Products products = new Products();
                products.setId_product(resultado.getInt(1));
                products.setName_product(resultado.getString(2));
                products.setMark(resultado.getString(3));
                products.setStock(resultado.getInt(4));
                products.setPrice(resultado.getDouble(5));
                products.setCategory(resultado.getString(6));
                products.setDate_in(resultado.getString(7));
                ListProducts.add(products);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return ListProducts;
    }
    public static Products getLastProduct(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select*from product_tbl where id_product=(select max(id_product) from product_tbl)");
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Products products=new Products();
                products.setId_product(resultado.getInt(1));
                products.setName_product(resultado.getString(2));
                products.setMark(resultado.getString(3));
                products.setStock(resultado.getInt(4));
                products.setPrice(resultado.getDouble(5));
                products.setCategory(resultado.getString(6));
                products.setDate_in(resultado.getString(7));
                return products;
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return null;
    }

}
