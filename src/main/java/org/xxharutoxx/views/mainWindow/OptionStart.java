package org.xxharutoxx.views.mainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionStart {
    private JPanel panelOptionStart;
    private JButton btnWelcome;
    private JButton btnCalculatorStart;
    private Welcome welcome;
    private JTabbedPane jTabbedPane;
    private CalculatorFrame calculatorFrame;


    public OptionStart(final JTabbedPane tabpanel){
        initComponent();
        this.jTabbedPane=tabpanel;
        btnCalculatorStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabpanel.indexOfComponent(calculatorFrame.getPanelCalculate())==-1){
                    tabpanel.add(calculatorFrame.getTitleCalculator(),calculatorFrame.getPanelCalculate());
//                    tabpanel.setTabComponentAt(tabpanel.getTabCount()-1,catalogue.getButton());

                }
                tabpanel.setSelectedComponent(calculatorFrame.getPanelCalculate());
            }
        });
    }

    public void initComponent(){
            welcome=new Welcome();
            calculatorFrame=new CalculatorFrame();
    }

    public Welcome getPanelFromWelcome(){
        return welcome;
    }

    public JPanel getPanelPrincipal(){
        return panelOptionStart;
    }
}
