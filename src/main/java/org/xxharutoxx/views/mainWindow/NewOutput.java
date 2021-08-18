package org.xxharutoxx.views.mainWindow;

import org.jdesktop.swingx.prompt.PromptSupport;
import org.xxharutoxx.controllers.CDescOutputProduct;
import org.xxharutoxx.controllers.COutputProduct;
import org.xxharutoxx.controllers.CProducts;
import org.xxharutoxx.models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class NewOutput {
    private JPanel panelNewOutput;
    private JComboBox boxSearchProduct;
    private JTextField txtQuantityProduct;
    private JButton btnConfirmOutput;
    private JTable tableDescNewOutputProduct;
    private JLabel lblIdProduct;
    private JComboBox boxUsersNewOutput;
    private JButton btnAddToDescTable;
    private JButton btnRemoveNewOutput;
    private final String title = "Nueva Salida";
    private DefaultTableModel productNewOutput;
    private DefaultTableModel productDescNewOutput;
    //    private String[] columnsTableNewOutput={"ID","ID DESCRIPCIÓN","USUARIO","FECHA"};
    private String[] columnsTableDescNewOutput = {"ID PRODUCTO", "PRODUCTO", "MARCA", "CATEGORÍA", "PRECIO", "CANTIDAD"};
    private ReceptionStock receptionStock;
    private Users users;
    private OutputProduct outputProduct;
    private DescOutputProduct descOutputProduct;
    private Products products;

    public NewOutput() {
        ReceptionStock.showProducts(boxSearchProduct);
        OutputProduct.showUsers(boxUsersNewOutput);
        initComponent();
        placeHolderText();
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
        boxSearchProduct.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (boxSearchProduct.getSelectedItem().equals("Seleccione un Producto")) {
                    lblIdProduct.setText(null);
                } else {
                    products = OutputProduct.getIdProduct(boxSearchProduct.getSelectedItem().toString());
                    lblIdProduct.setText(String.valueOf(products.getId_product()));
                }

            }
        });
        btnAddToDescTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!boxSearchProduct.getSelectedItem().equals("Seleccione un Producto") && !boxUsersNewOutput.getSelectedItem().equals("Seleccione un Usuario") && !txtQuantityProduct.getText().isEmpty()){
                    addToTableDescProduct();
                }else{
                    JOptionPane.showMessageDialog(null,"Por favor complete todo los espacios requeridos");
                }

            }
        });
        btnConfirmOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                saveNewOutputProduct();
//                saveDescProduct();
//                cleanInputs();
//                productDescNewOutput = (DefaultTableModel)tableDescNewOutputProduct.getModel();
//                while(productDescNewOutput.getRowCount() > 0)
//                {
//                    productDescNewOutput.removeRow(0);
//                }
                confirmUserWithPassword();
            }
        });
        btnRemoveNewOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableDescNewOutputProduct.getSelectedRow() != -1) {
                    productDescNewOutput.removeRow(tableDescNewOutputProduct.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Se quitó el Item");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un item para quitar");
                }
            }
        });
    }

    public JPanel getPanelNewOutput() {
        return panelNewOutput;
    }

    public String getTitle() {
        return title;
    }

    public void initComponent() {
//        tableProductNewOutput.setModel(new DefaultTableModel(null,columnsTableNewOutput));
//        productNewOutput= (DefaultTableModel) tableProductNewOutput.getModel();
        tableDescNewOutputProduct.setModel(new DefaultTableModel(null, columnsTableDescNewOutput));
        productDescNewOutput = (DefaultTableModel) tableDescNewOutputProduct.getModel();
    }

    public void addToTableDescProduct() {
        outputProduct = outputProduct.getLastIdOutputProduct();
        products = OutputProduct.getOneProduct(boxSearchProduct.getSelectedItem().toString());
        Object[] getOneProduct = new Object[6];
        getOneProduct[0] = products.getId_product();
        getOneProduct[1] = products.getName_product();
        getOneProduct[2] = products.getMark();
        getOneProduct[3] = products.getCategory();
        getOneProduct[4] = products.getPrice();
        getOneProduct[5] = txtQuantityProduct.getText();
        productDescNewOutput.addRow(getOneProduct);
        tableDescNewOutputProduct.setModel(productDescNewOutput);
    }

    public void saveDescProduct() {
        outputProduct = outputProduct.getLastIdOutputProduct();
        int id_output = outputProduct.getId_outputProduct();
        String name_product;
        int quantityRow;
        int id_product;
//        productDescNewOutput= (DefaultTableModel) tableDescNewOutputProduct.getModel();
//        if(productDescNewOutput.getRowCount()==0){
//            JOptionPane.showMessageDialog(null,"Inserte datos a la tabla");
//        }else{
        try {
            for (int i = 0; i < productDescNewOutput.getRowCount(); i++) {
//                    id_output=Integer.parseInt(productDescNewOutput.getValueAt(i,0).toString());
                name_product = productDescNewOutput.getValueAt(i, 1).toString();
                quantityRow = Integer.parseInt(productDescNewOutput.getValueAt(i, 5).toString());
                id_product = Integer.parseInt(productDescNewOutput.getValueAt(i, 0).toString());
//                    descOutputProduct = CDescOutputProduct.CCreateDescOutputProduct(name_product,quantityRow,id_output,id_product);
                descOutputProduct = new DescOutputProduct(null, name_product, quantityRow, id_output, id_product);
                descOutputProduct = CDescOutputProduct.CUpdateStockProduct(quantityRow, id_product);
                System.out.println("q " + quantityRow);
                System.out.println("id p " + id_product);
                System.out.println("id s " + id_output);
                System.out.println("name " + name_product);

                if (!descOutputProduct.updateStockProduct()) {
//                        cleanInputs();
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no guardado");
                }

            }
//                JOptionPane.showMessageDialog(null, "Producto Guardado");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        }
    }

    public void saveNewOutputProduct() {
//        String user_output=boxUsersNewOutput.getSelectedItem().toString();
        users = outputProduct.getFullNamesUser(boxUsersNewOutput.getSelectedItem().toString());
        outputProduct = COutputProduct.CCreateOutputProduct(users.getFullNames());
        try {
            if (!outputProduct.createOutputProduct()) {
                JOptionPane.showMessageDialog(null, "Producto sacado con exito");
//                        cleanInputs();
            } else {
                JOptionPane.showMessageDialog(null, "Producto no guardado");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void cleanInputs() {
        boxSearchProduct.setSelectedItem("Seleccione un Producto");
        boxUsersNewOutput.setSelectedItem("Seleccione un Usuario");
        txtQuantityProduct.setText(null);
        lblIdProduct.setText(null);
    }

    public void confirmUserWithPassword() {
        productDescNewOutput = (DefaultTableModel) tableDescNewOutputProduct.getModel();
        if (productDescNewOutput.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Inserte datos a la tabla");
        } else {
//            String confirm=JOptionPane.showInputDialog(null,"Ingrese su contraseña","Contraseña",JOptionPane.QUESTION_MESSAGE);
            JPasswordField pf = new JPasswordField();
            int okConfirm = JOptionPane.showConfirmDialog(null, pf, "Ingrese su contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (okConfirm == JOptionPane.OK_OPTION) {
                String password = new String(pf.getPassword());
                System.err.println("Ingresaste: " + password);
                String user = boxUsersNewOutput.getSelectedItem().toString();
                String password_user =password ;
                users = Users.login(user, password_user);
                try {
                    if (users != null) {
                        saveNewOutputProduct();
                        saveDescProduct();
                        cleanInputs();
                        productDescNewOutput = (DefaultTableModel) tableDescNewOutputProduct.getModel();
                        while (productDescNewOutput.getRowCount() > 0) {
                            productDescNewOutput.removeRow(0);
                        }
                        System.out.println("SI llega aqui");
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña o Usuario son incorrectos");

                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        }
    }
    private void placeHolderText(){
        PromptSupport.setPrompt("Cantidad",txtQuantityProduct);
    }

}
