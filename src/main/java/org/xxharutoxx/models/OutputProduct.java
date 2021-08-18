package org.xxharutoxx.models;

import org.xxharutoxx.connection.ConnectionSQlite;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OutputProduct extends ConnectionSQlite {
    private Integer id_outputProduct;
    private String user_output;
    private String date_out;

    public OutputProduct() {
    }

    public OutputProduct(Integer id_outputProduct, String user_output, String date_out) {
        this.id_outputProduct = id_outputProduct;
        this.user_output = user_output;
        this.date_out = date_out;
    }

    public Integer getId_outputProduct() {
        return id_outputProduct;
    }

    public void setId_outputProduct(Integer id_outputProduct) {
        this.id_outputProduct = id_outputProduct;
    }

    public String getUser_output() {
        return user_output;
    }

    public void setUser_output(String user_output) {
        this.user_output = user_output;
    }

    public String getDate_out() {
        return date_out;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public boolean createOutputProduct(){
        try{
            Date date=new Date();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            openConexion();
            consulta=conexion.prepareStatement("insert into outputProduct_tbl values(null,?,?)");
            consulta.setString(1,getUser_output());
            consulta.setString(2,String.valueOf(sqlDate));
            return consulta.execute();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }
    public boolean deleteOutputProduct(int id){
        try {
            openConexion();
            consulta=conexion.prepareStatement("delete from outputProduct_tbl where id_outputProduct=?");
            consulta.setInt(1,id);
            return consulta.execute();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }
    public static Users getFullNamesUser(String nameUser) {
        Users idUser = null;
        try {
            openConexion();
            consulta = conexion.prepareStatement("select fullNames from users_tbl where users=?");
            consulta.setString(1, nameUser);
            resultado = consulta.executeQuery();
            if (resultado.next()) {
                idUser = new Users();
                idUser.setFullNames(resultado.getString(1));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConexion();
        }
        return idUser;
    }
    public static DescOutputProduct getIdDesc(int id_desc_outputProduct) {
        DescOutputProduct idDesc = null;
        try {
            openConexion();
            consulta = conexion.prepareStatement("select id_desc_outputProduct from desc_outputProduct_tbl where id_desc_outputProduct=?");
            consulta.setInt(1, id_desc_outputProduct);
            resultado = consulta.executeQuery();
            if (resultado.next()) {
                idDesc = new DescOutputProduct();
                idDesc.setId_desc_outputProduct(resultado.getInt(1));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConexion();
        }
        return idDesc;
    }
    public static OutputProduct getLastIdOutputProduct(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select id_outputProduct from outputProduct_tbl where id_outputProduct=(select max(id_outputProduct) from outputProduct_tbl)");
            resultado=consulta.executeQuery();
            if(resultado.next()){
                OutputProduct u=new OutputProduct();
                u.setId_outputProduct(resultado.getInt(1));

                return u;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return null;
    }

    public static Products getIdProduct(String nameProduct) {
        Products products = null;
        try {
            openConexion();
            consulta = conexion.prepareStatement("select id_product from product_tbl where name_product=?");
            consulta.setString(1, nameProduct);
            resultado = consulta.executeQuery();
            if (resultado.next()) {
                products = new Products();
                products.setId_product(resultado.getInt(1));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConexion();
        }
        return products;
    }

    public static void showUsers(JComboBox jComboBox){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select users from users_tbl");
            resultado=consulta.executeQuery();
            jComboBox.addItem("Seleccione un Usuario");
            while (resultado.next()){
                jComboBox.addItem(resultado.getString(1));
            }
        }catch (Exception ex){

        }finally {
            closeConexion();
        }
    }
    public static void showCategories(JComboBox jComboBox){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select category from product_tbl group by category");
            resultado=consulta.executeQuery();
            jComboBox.addItem("Seleccione una Categoría");
            while (resultado.next()){
                jComboBox.addItem(resultado.getString(1));
            }
        }catch (Exception ex){

        }finally {
            closeConexion();
        }
    }
    public static void showMarks(JComboBox jComboBox){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select mark from product_tbl group by mark");
            resultado=consulta.executeQuery();
            jComboBox.addItem("Seleccione una Marca");
            while (resultado.next()){
                jComboBox.addItem(resultado.getString(1));
            }
        }catch (Exception ex){

        }finally {
            closeConexion();
        }
    }
    public static void showPrices(JComboBox jComboBox){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select price from product_tbl group by price");
            resultado=consulta.executeQuery();
            jComboBox.addItem("Seleccione un Precio");
            while (resultado.next()){
                jComboBox.addItem(resultado.getDouble(1));
            }
        }catch (Exception ex){

        }finally {
            closeConexion();
        }
    }

    public static Products getOneProduct(String nameProduct){
        Products products=null;
        try {
            openConexion();
            consulta=conexion.prepareStatement("select id_product, name_product, mark, category, price from product_tbl where name_product=?");
            consulta.setString(1,nameProduct);
            resultado=consulta.executeQuery();
            if(resultado.next()){
                products=new Products();
                products.setId_product(resultado.getInt(1));
                products.setName_product(resultado.getString(2));
                products.setMark(resultado.getString(3));
                products.setCategory(resultado.getString(4));
                products.setPrice(resultado.getDouble(5));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return products;
    }
    public static List<Products> getMarksProduct(String marks){
        List<Products> ListProducts=new ArrayList<>();
        try {
            openConexion();
            consulta=conexion.prepareStatement("select * from product_tbl where mark=?");
            consulta.setString(1, marks);
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
                ListProducts.add(products);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return ListProducts;
    }
    public static List<Products> getProductsByCategory(String category){
        List<Products> ListProducts=new ArrayList<>();
        try{
            openConexion();
            consulta=conexion.prepareStatement("select*from product_tbl where category=?");
            consulta.setString(1,category);
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
    public static List<String[]> getOutputProduct(){
        List<String[]>dataProduct=new ArrayList<String[]>();
        String name[];
        try{

            openConexion();
            consulta=conexion.prepareStatement("SELECT opt.id_outputProduct,dopt.id_desc_outputProduct,pt.id_product, opt.user_output ,dopt.name_product,pt.category, pt.mark, dopt.quantity_output ,opt.date_out FROM outputProduct_tbl opt \n" +
                    "INNER JOIN desc_outputProduct_tbl dopt ON opt.id_outputProduct =dopt.id_outputProduct\n" +
                    "INNER JOIN product_tbl pt on pt.id_product =dopt.id_product");
            resultado=consulta.executeQuery();
            while (resultado.next()) {
                name=new String[9];
                name[0]=String.valueOf(resultado.getInt(1));
                name[1]=String.valueOf(resultado.getInt(2));
                name[2]=String.valueOf(resultado.getInt(3));
                name[3]=resultado.getString(4);
                name[4]=resultado.getString(5);
                name[5]=resultado.getString(6);
                name[6]=resultado.getString(7);
                name[7]=String.valueOf(resultado.getInt(8));
                name[8]=resultado.getString(9);
                dataProduct.add(name);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return dataProduct;
    }

}
