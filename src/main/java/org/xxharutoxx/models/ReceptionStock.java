package org.xxharutoxx.models;

import org.xxharutoxx.connection.ConnectionSQlite;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceptionStock extends ConnectionSQlite {
    private Integer id_receptionStock;
    private Integer quantity;
    private boolean state;
    private String date_entry;
    private String name_product;

    public ReceptionStock() {
        state=true;
    }

    public ReceptionStock(Integer id_receptionStock, Integer quantity, boolean state, String date_entry, String name_product) {
        this.id_receptionStock = id_receptionStock;
        this.quantity = quantity;
        this.state = state;
        this.date_entry = date_entry;
        this.name_product=name_product;
//        updateStock(quantity,name_product);
//        receptionProduct();
    }

    public Integer getId_receptionStock() {
        return id_receptionStock;
    }

    public void setId_receptionStock(Integer id_receptionStock) {
        this.id_receptionStock = id_receptionStock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDate_entry() {
        return date_entry;
    }

    public void setDate_entry(String date_entry) {
        this.date_entry = date_entry;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public boolean receptionProduct(){
        try {
            Date date=new Date();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            openConexion();
            consulta=conexion.prepareStatement("insert into receptionStock_tbl values (null,?,?,?,?)");
//            consulta.setInt(1, getId_receptionStock());
            consulta.setInt(1, getQuantity());
            consulta.setBoolean(2,isState());
            consulta.setString(3,String.valueOf(sqlDate));
            consulta.setString(4,getName_product());
            return consulta.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }
    public void updateStock(int quantity,String nameProduct){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select stock from product_tbl where name_product =?");
            consulta.setString(1,nameProduct);
            resultado=consulta.executeQuery();
            int stockInitial;
            int stockFinal=0;
            if(resultado.next()){
                stockInitial= resultado.getInt(1);
                stockFinal=(stockInitial+quantity);
                System.out.println(stockInitial);
            }
            System.out.println(stockFinal);
            consulta=conexion.prepareStatement("update product_tbl set stock=? where name_product=? ");
            consulta.setInt(1,stockFinal);
            consulta.setString(2,nameProduct);
            consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
    }
    public static void showProducts(JComboBox jComboBox){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select name_product from product_tbl");
            resultado=consulta.executeQuery();
            jComboBox.addItem("Seleccione un Producto");
            while (resultado.next()){
                jComboBox.addItem(resultado.getString(1));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
    }
    public List<ReceptionStock> getReceptionStock(){
        List<ReceptionStock> receptionStockList=new ArrayList<>();
        try {
            openConexion();
            consulta=conexion.prepareStatement("select*from receptionStock_tbl");
            resultado=consulta.executeQuery();
            while (resultado.next()){
                ReceptionStock receptionStock=new ReceptionStock();
                receptionStock.setId_receptionStock(resultado.getInt(1));
                receptionStock.setQuantity(resultado.getInt(2));
                receptionStock.setState(resultado.getBoolean(3));
                receptionStock.setDate_entry(resultado.getString(4));
                receptionStock.setName_product(resultado.getString(5));
                receptionStockList.add(receptionStock);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return receptionStockList;
    }
    public boolean updateStockProductFromReception(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("update product_tbl set stock =(product_tbl.stock + ?) where name_product =?");
            consulta.setInt(1,getQuantity());
            consulta.setString(2,getName_product());
            return consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }
    public static ReceptionStock getLastReceptionStock(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select*from receptionStock_tbl where id_receptionstock=(select max(id_receptionstock) from receptionStock_tbl)");
            resultado=consulta.executeQuery();
            if(resultado.next()){
                ReceptionStock receptionStock=new ReceptionStock();
                receptionStock.setId_receptionStock(resultado.getInt(1));
                receptionStock.setQuantity(resultado.getInt(2));
                receptionStock.setState(resultado.getBoolean(3));
                receptionStock.setDate_entry(resultado.getString(4));
                receptionStock.setName_product(resultado.getString(5));
                return receptionStock;
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return null;
    }
}
