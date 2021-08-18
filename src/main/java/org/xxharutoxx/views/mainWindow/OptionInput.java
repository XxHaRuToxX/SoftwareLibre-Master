package org.xxharutoxx.views.mainWindow;

import org.xxharutoxx.models.ReceptionStock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionInput {
    private JButton btnRegisterProduct;
    private JPanel panelOptionInput;
    private JButton btnRegisterInput;
    private ProductInput productInput;
    private ProductRegister productRegister;
    private JTabbedPane jTabbedPane;
    private ReceptionStock receptionStock;

    public JButton getBtnRegisterProduct() {
        return btnRegisterProduct;
    }

    public void setBtnRegisterProduct(JButton btnRegisterProduct) {
        this.btnRegisterProduct = btnRegisterProduct;
    }

    public OptionInput(final JTabbedPane tabpanel) {
        initComponents();
        receptionStock=new ReceptionStock();
        receptionStock.getReceptionStock();
        this.jTabbedPane=tabpanel;
        btnRegisterInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabpanel.indexOfComponent(productInput.getPanelProductInput())==-1){
                    tabpanel.add(productInput.getTitle(),productInput.getPanelProductInput());
                }
                tabpanel.setSelectedComponent(productInput.getPanelProductInput());
            }
        });
        btnRegisterProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabpanel.indexOfComponent(productRegister.getPanelProductRegister())==-1){
                    tabpanel.add(productRegister.getTitle(),productRegister.getPanelProductRegister());
                }
                tabpanel.setSelectedComponent(productRegister.getPanelProductRegister());
            }
        });
    }

    private void initComponents(){
        productInput=new ProductInput();
        productRegister=new ProductRegister();
    }

    public JPanel getPanelPrincipal(){
        return panelOptionInput;
    }
}
