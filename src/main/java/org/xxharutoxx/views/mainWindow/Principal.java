package org.xxharutoxx.views.mainWindow;

import org.xxharutoxx.models.Users;
import org.xxharutoxx.views.Login;
import org.xxharutoxx.views.NewUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JPanel panelPrincipal;
    private JButton btnUsers;
    private JButton btnCloseSession;
    private JButton btnStart;
    private JButton btnSales;
    private JButton btnEntry;
    private JTabbedPane tabbedPane;
    private JSplitPane jSplitPane;
    private JPanel jpanelCenter;
    private Dimension dimension;
    private OptionStart optionStart;
    private OptionOutput optionOutput;
    private OptionInput optionInput;


    public Principal(Users priv){
        initComponent();
        if(priv.getRol().equals("Asistente")){
            optionOutput.getBtnRemoveOutput().setVisible(false);
            btnUsers.setVisible(false);
            btnCloseSession.setVisible(true);
            optionInput.getBtnRegisterProduct().setVisible(false);

        }else{
            btnUsers.setVisible(true);
            btnCloseSession.setVisible(true);
            optionOutput.getBtnRemoveOutput().setVisible(true);
            optionInput.getBtnRegisterProduct().setVisible(true);
        }
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jSplitPane.setLeftComponent(optionStart.getPanelPrincipal());
            }
        });
        btnSales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jSplitPane.setLeftComponent(optionOutput.getPanelPrincipal());
            }
        });

        btnEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jSplitPane.setLeftComponent(optionInput.getPanelPrincipal());
            }
        });
        btnCloseSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeSession();
            }
        });
        btnUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewUser newUser=new NewUser();
                newUser.setVisible(true);
            }
        });
    }
    public void initComponent(){
        dimension=new Dimension();
        dimension.width=1060;
        dimension.height=600;
        setContentPane(panelPrincipal);
        setSize(1060,600);
        setMinimumSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        optionStart=new OptionStart(tabbedPane);
        optionOutput =new OptionOutput(tabbedPane);
        optionInput=new OptionInput(tabbedPane);
        jSplitPane.setLeftComponent(optionStart.getPanelPrincipal());
        tabbedPane.add(optionStart.getPanelFromWelcome().getTitle(),optionStart.getPanelFromWelcome().getPanelWelcome());
    }

    public void loadLoginPanel1(){
        Login log=new Login();
        log.setVisible(true);
    }
    public void closeSession(){
        Login p=new Login();
        p.setVisible(true);
        dispose();
    }
    public void nonDuplicatePanel(){
        if (jSplitPane.getComponentCount()==1){
            jSplitPane.setLeftComponent(null);
        }
    }

}
