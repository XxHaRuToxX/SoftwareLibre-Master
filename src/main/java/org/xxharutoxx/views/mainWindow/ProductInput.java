package org.xxharutoxx.views.mainWindow;

import org.xxharutoxx.controllers.CProducts;
import org.xxharutoxx.controllers.CReceptionStock;
import org.xxharutoxx.controllers.CUsers;
import org.xxharutoxx.models.ReceptionStock;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ProductInput {
    private JPanel panelProductInput;
    private JTable tableProductInput;
    private JTextField txtQuantityProduct;
    private JTextField textField3;
    private JButton btnInputProduct;
    private JButton CANCELARButton;
    private JTextField txtNameProduct;
    private JComboBox boxStateProductInput;
    private JComboBox boxNameProductInput;
    private JLabel lblDateProductInput;
    private DefaultTableModel productInput;
    private final String title="Ingresar Producto";
    private String[] columnsTableProductInput={"ID","NOMBRE","CANTIDAD","ESTADO","FECHA"};
    private ReceptionStock receptionStock;

    public ProductInput(){
        initComponent();
        getReceptionStock();
        initialRender();
        ReceptionStock.showProducts(boxNameProductInput);
        txtQuantityProduct.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if(((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)){
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        btnInputProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!boxNameProductInput.getSelectedItem().equals("Seleccione un Producto") && !boxStateProductInput.getSelectedItem().equals("Seleccione un Estado") && !txtQuantityProduct.getText().isEmpty()){
                    reception_Stock();
                    receptionStock= CReceptionStock.CGetLastReceptionStock();
                    Object[] getLastReception=new Object[5];
                    getLastReception[0]=receptionStock.getId_receptionStock();
                    getLastReception[1]=receptionStock.getName_product();
                    getLastReception[2]=receptionStock.getQuantity();
                    getLastReception[3]=receptionStock.isState() ? "Disponible" : "No disponible";
                    getLastReception[4]=receptionStock.getDate_entry();
                    productInput.addRow(getLastReception);
                    tableProductInput.setModel(productInput);
                    cleanControls();
                }else{
                    JOptionPane.showMessageDialog(null,"Por favor complete todo los espacios requeridos");
                }

            }
        });
    }
    public JPanel getPanelProductInput(){
        return panelProductInput;
    }
    public String getTitle(){
        return title;
    }
    public void initComponent(){
        tableProductInput.setModel(new DefaultTableModel(null,columnsTableProductInput));
        productInput= (DefaultTableModel) tableProductInput.getModel();
        dateProductInput();
    }

    public void reception_Stock(){
        boolean stateProductInput= Boolean.parseBoolean(String.valueOf(boxStateProductInput.getSelectedItem().equals("Disponible")?true:false));
        String name_product=String.valueOf(boxNameProductInput.getSelectedItem());
        int quantityProduct=Integer.parseInt(txtQuantityProduct.getText());
//        boolean productState=Boolean.parseBoolean(txtStateProduct.getText());
//        receptionStock=new ReceptionStock(null,quantityProduct,productState,null,name_product);
        receptionStock= CReceptionStock.CReceptionProduct(quantityProduct,stateProductInput,name_product);
        try{
            if(!receptionStock.receptionProduct()){
                receptionStock.updateStock(quantityProduct,name_product);
                JOptionPane.showMessageDialog(null,"Registro realizado");
            }else{
                JOptionPane.showMessageDialog(null,"no se REgistro usuario");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void getReceptionStock(){
        List<ReceptionStock> getListReceptionStock=CReceptionStock.CGetReceptionStock();
        productInput= (DefaultTableModel) tableProductInput.getModel();
        Object[]listReceptionStock=new Object[5];
        for (int i=0;i<getListReceptionStock.size();i++){
            listReceptionStock[0]=getListReceptionStock.get(i).getId_receptionStock();
            listReceptionStock[1]=getListReceptionStock.get(i).getName_product();
            listReceptionStock[2]=getListReceptionStock.get(i).getQuantity();
            listReceptionStock[3]= getListReceptionStock.get(i).isState() ?"Disponible":"No disponible";
            listReceptionStock[4]=getListReceptionStock.get(i).getDate_entry();
            productInput.addRow(listReceptionStock);
        }
        tableProductInput.setModel(productInput);
    }
    public void cleanControls(){
        txtQuantityProduct.setText(null);
        boxNameProductInput.setSelectedItem("Seleccione un Producto");
        boxStateProductInput.setSelectedItem("Disponible");
    }
    public void initialRender(){
        DefaultTableCellRenderer center=new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        for (int columnIndex = 0; columnIndex < tableProductInput.getColumnCount(); columnIndex++) {
            tableProductInput.getColumnModel().getColumn(columnIndex).setCellRenderer(center);
        }
    }
    public void dateProductInput(){
        Calendar calendar=new GregorianCalendar();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        lblDateProductInput.setText(String.format("%02d",day)+" / "+String.format("%02d",(month+1))+" / "+year);
    }
}
