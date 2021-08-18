package org.xxharutoxx.models;

import org.xxharutoxx.connection.ConnectionSQlite;

import java.util.ArrayList;
import java.util.List;

public class DescOutputProduct extends ConnectionSQlite {
    private Integer id_desc_outputProduct;
    private String name_product;
    private Integer quantity_product;
    private Integer id_outputProduct;
    private Integer id_product;

    public DescOutputProduct() {
    }

    public DescOutputProduct(Integer id_desc_outputProduct, String name_product, Integer quantity_product, Integer id_outputProduct, Integer id_product) {
        this.id_desc_outputProduct = id_desc_outputProduct;
        this.name_product = name_product;
        this.quantity_product = quantity_product;
        this.id_outputProduct = id_outputProduct;
        this.id_product = id_product;
        saveDescOutputProduct();
    }

    public Integer getId_desc_outputProduct() {
        return id_desc_outputProduct;
    }

    public void setId_desc_outputProduct(Integer id_desc_outputProduct) {
        this.id_desc_outputProduct = id_desc_outputProduct;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public Integer getQuantity_product() {
        return quantity_product;
    }

    public void setQuantity_product(Integer quantity_product) {
        this.quantity_product = quantity_product;
    }

    public Integer getId_outputProduct() {
        return id_outputProduct;
    }

    public void setId_outputProduct(Integer id_outputProduct) {
        this.id_outputProduct = id_outputProduct;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public boolean saveDescOutputProduct(){
        try{
            openConexion();
            consulta=conexion.prepareStatement("insert into desc_outputProduct_tbl values (null,?,?,?,?)");
            consulta.setString(1,getName_product());
            consulta.setInt(2,getQuantity_product());
            consulta.setInt(3,getId_outputProduct());
            consulta.setInt(4,getId_product());
            return consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }
    public boolean updateStockProduct(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("update product_tbl set stock =(product_tbl.stock - ?) where id_product =?");
            consulta.setInt(1,getQuantity_product());
            consulta.setInt(2,getId_product());
            return consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }
    public boolean deleteDescOutputProduct(int id){
        try {
            openConexion();
            consulta=conexion.prepareStatement("delete from desc_outputProduct_tbl where id_desc_outputProduct=?");
            consulta.setInt(1,id);
            return consulta.execute();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }

    public static List<DescOutputProduct> getDescOutputProduct(){
        List<DescOutputProduct> ListDescOutput=new ArrayList<>();
        try{
            openConexion();
            consulta=conexion.prepareStatement("select name_product, quantity_output from desc_outputProduct_tbl");
            resultado=consulta.executeQuery();
            while (resultado.next()) {
                DescOutputProduct descOutput = new DescOutputProduct();
                descOutput.setName_product(resultado.getString(1));
                descOutput.setQuantity_product(resultado.getInt(2));
                ListDescOutput.add(descOutput);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return ListDescOutput;
    }
}
