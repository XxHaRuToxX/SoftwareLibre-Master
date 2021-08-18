package org.xxharutoxx.views.mainWindow;

import org.xxharutoxx.controllers.CProducts;
import org.xxharutoxx.models.Products;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ProductRegister {
    private JPanel panelProductRegister;
    private JTextField txtNameProduct;
    private JTextField txtMark;
    private JTextField txtStock;
    private JTextField txtCategory;
    private JTextField txtPrice;
    private JTable tableRegisterProduct;
    private JButton btnRegisterProduct;
    private JButton btnDeleteProduct;
    private JLabel lblDateProductRegister;
    private Products products;

    private DefaultTableModel productRegister;
    private final String title="Registrar Producto";
    private String[] columnsTableProductRegister={"ID","NOMBRE","MARCA","CATEGORÍA","STOCK","PRECIO","FECHA"};

    public ProductRegister(){
        initComponent();
        getProducts();
        btnRegisterProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(notEmptySpace()){
                    saveProduct();
                    products=CProducts.CGetLastProduct();
                    Object[] getLastProduct=new Object[7];
                    getLastProduct[0]=products.getId_product();
                    getLastProduct[1]=products.getName_product();
                    getLastProduct[2]=products.getMark();
                    getLastProduct[3]=products.getCategory();
                    getLastProduct[4]=products.getStock();
                    getLastProduct[5]=products.getPrice();
                    getLastProduct[6]=products.getDate_in();
                    productRegister.addRow(getLastProduct);
                    tableRegisterProduct.setModel(productRegister);
                }else {
                    JOptionPane.showMessageDialog(null,"Por favor complete todos los espacios requeridos");
                }

            }
        });
    }
    public JPanel getPanelProductRegister(){
        return panelProductRegister;
    }
    public String getTitle(){
        return title;
    }
    public void initComponent(){
        tableRegisterProduct.setModel(new DefaultTableModel(null,columnsTableProductRegister));
        productRegister= (DefaultTableModel) tableRegisterProduct.getModel();
        dateProductRegister();
    }

    public void saveProduct(){
        String name_product=txtNameProduct.getText();
        String mark=txtMark.getText();
        int stock= Integer.parseInt(txtStock.getText());
        double price=Double.parseDouble(txtPrice.getText());
        String category=txtCategory.getText();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date=new Date();
//        String date_in=txtDate.getText();

        products= CProducts.createProduct(name_product,mark,stock,price,category);
        try {
            if(!products.createProduct()){
                JOptionPane.showMessageDialog(null,"Producto Guardado");
                cleanInputs();
            }else{
                JOptionPane.showMessageDialog(null,"Producto no guardado");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void cleanInputs(){
        txtNameProduct.setText(null);
        txtMark.setText(null);
        txtStock.setText(null);
        txtPrice.setText(null);
        txtCategory.setText(null);
    }
    public  void getProducts(){
        List<Products> getProductsList=CProducts.CListProducts();
        productRegister= (DefaultTableModel) tableRegisterProduct.getModel();
        Object[] objectProduct=new Object[7];
        for(int i=0;i<getProductsList.size();i++){
            objectProduct[0]=getProductsList.get(i).getId_product();
            objectProduct[1]=getProductsList.get(i).getName_product();
            objectProduct[2]=getProductsList.get(i).getMark();
            objectProduct[3]=getProductsList.get(i).getCategory();
            objectProduct[4]=getProductsList.get(i).getStock();
            objectProduct[5]=getProductsList.get(i).getPrice();
            objectProduct[6]=getProductsList.get(i).getDate_in();
            productRegister.addRow(objectProduct);
        }
        tableRegisterProduct.setModel(productRegister);
    }

    public boolean notEmptySpace(){
        if(!(txtNameProduct.getText().isEmpty() || txtMark.getText().isEmpty() || txtCategory.getText().isEmpty() || txtStock.getText().isEmpty() || txtPrice.getText().isEmpty())){
            return true;
        }else{
            return false;
        }
    }
    public void dateProductRegister(){
        Calendar calendar=new GregorianCalendar();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        lblDateProductRegister.setText(String.format("%02d",day)+" / "+String.format("%02d",(month+1))+" / "+year);
    }


}
