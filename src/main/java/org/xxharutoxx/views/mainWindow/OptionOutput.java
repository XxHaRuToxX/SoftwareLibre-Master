package org.xxharutoxx.views.mainWindow;

import org.xxharutoxx.models.Users;

import javax.swing.*;
import java.awt.event.*;

public class OptionOutput {
    private JPanel panelOptionOutput;
    private JButton btnNewOutput;
    private JButton btnCatalogue;
    private JButton btnRemoveOutput;
    private Catalogue catalogue;
    private NewOutput newOutput;
    private CancelOutput cancelOutput;
    private JTabbedPane jTabbedPane;

    public JButton getBtnRemoveOutput() {
        return btnRemoveOutput;
    }

    public void setBtnRemoveOutput(JButton btnRemoveOutput) {
        this.btnRemoveOutput = btnRemoveOutput;
    }

    public OptionOutput(final JTabbedPane tabpanel){

        initComponents();
        this.jTabbedPane=tabpanel;
        btnCatalogue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabpanel.indexOfComponent(catalogue.getPanelCatalogue())==-1){
                    tabpanel.add(catalogue.getTitle(),catalogue.getPanelCatalogue());
//                    tabpanel.setTabComponentAt(tabpanel.getTabCount()-1,catalogue.getButton());

                }
                tabpanel.setSelectedComponent(catalogue.getPanelCatalogue());
            }
        });
        tabpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    int index=tabpanel.getSelectedIndex();
                    if(index!=0){
                        JPopupMenu popupMenu=new JPopupMenu();
                        JMenuItem delete=new JMenuItem("X");
                        delete.setBorderPainted(false);
                        delete.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                tabpanel.remove(index);
                            }
                        });
                        popupMenu.add(delete);
                        popupMenu.show(tabpanel,e.getX(),e.getY());
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        btnNewOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabpanel.indexOfComponent(newOutput.getPanelNewOutput())==-1){
                    tabpanel.add(newOutput.getTitle(),newOutput.getPanelNewOutput());
                }
                tabpanel.setSelectedComponent(newOutput.getPanelNewOutput());
            }
        });
        btnRemoveOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabpanel.indexOfComponent(cancelOutput.getPanelCancelOutput())==-1){
                    tabpanel.add(cancelOutput.getTitle(),cancelOutput.getPanelCancelOutput());
                }
                tabpanel.setSelectedComponent(cancelOutput.getPanelCancelOutput());
            }
        });
    }

    private void initComponents(){
        catalogue=new Catalogue();
        newOutput=new NewOutput();
        cancelOutput=new CancelOutput();
    }
    public JPanel getPanelPrincipal(){
        return panelOptionOutput;
    }
}
