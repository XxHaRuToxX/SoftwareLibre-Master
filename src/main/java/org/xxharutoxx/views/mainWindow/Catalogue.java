package org.xxharutoxx.views.mainWindow;

import org.jdesktop.swingx.prompt.PromptSupport;
import org.xxharutoxx.controllers.CProducts;
import org.xxharutoxx.models.OutputProduct;
import org.xxharutoxx.models.Products;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Objects;

public class Catalogue {
    private JPanel panelCatalogue;
    private JComboBox boxCategory;
    private JComboBox boxMark;
    private JComboBox boxPrice;
    private JTable tableCatalogue;
    private JTextField txtSearchProductCatalogue;
    private JComboBox comboBox1;
    private DefaultTableModel productCatalogue;
    private final String title="Catálogo";
    private final String[] columnsTableCatalogue={"ID","NOMBRE","MARCA","CATEGORÍA","STOCK","PRECIO","FECHA"};
    private OutputProduct outputProduct;
    private Products products;
    private final NumberFormat soles=NumberFormat.getCurrencyInstance();
    private final DecimalFormatSymbols decimalFormatSymbols=new DecimalFormatSymbols();


    public Catalogue(){
        initComponent();
        initialRender();
        placeHolderText();
        boxCategory.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Objects.equals(boxCategory.getSelectedItem(), "Seleccione una Categoría")) {
                    clearTable();
                    getProducts();
                } else {
                    clearTable();
                    itemCategorySelecting();
                }
            }
        });
        boxMark.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (Objects.equals(boxMark.getSelectedItem(), "Seleccione una Marca")) {
                    clearTable();
                    getProducts();
                } else {
                    clearTable();
                    itemMarkSelecting();

                }
            }
        });
        txtSearchProductCatalogue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filterAnyElement(txtSearchProductCatalogue.getText(),tableCatalogue);
            }
        });
    }
    public JPanel getPanelCatalogue(){
        return panelCatalogue;
    }
    public String getTitle(){
        return title;
    }
    public void initComponent(){
        tableCatalogue.setModel(new DefaultTableModel(null,columnsTableCatalogue));
        productCatalogue= (DefaultTableModel) tableCatalogue.getModel();
        OutputProduct.showCategories(boxCategory);
        OutputProduct.showMarks(boxMark);
        OutputProduct.showPrices(boxPrice);
        getProducts();
    }
    public  void getProducts(){
        decimalFormatSymbols.setCurrencySymbol("S/. ");
        ((DecimalFormat) soles).setDecimalFormatSymbols(decimalFormatSymbols);
        List<Products> getProducts= CProducts.CListProducts();
        productCatalogue= (DefaultTableModel) tableCatalogue.getModel();
        Object[] objectProduct=new Object[7];
        for (Products getProduct : getProducts) {
            objectProduct[0] = getProduct.getId_product();
            objectProduct[1] = getProduct.getName_product();
            objectProduct[2] = getProduct.getMark();
            objectProduct[3] = getProduct.getCategory();
            objectProduct[4] = getProduct.getStock();
            objectProduct[5] = soles.format(getProduct.getPrice());
            objectProduct[6] = getProduct.getDate_in();
            productCatalogue.addRow(objectProduct);
        }
        tableCatalogue.setModel(productCatalogue);
    }
    public void itemCategorySelecting(){
        decimalFormatSymbols.setCurrencySymbol("S/. ");
        ((DecimalFormat) soles).setDecimalFormatSymbols(decimalFormatSymbols);
        List<Products> getProducts= OutputProduct.getProductsByCategory(boxCategory.getSelectedItem().toString());
        productCatalogue= (DefaultTableModel) tableCatalogue.getModel();
        Object[] objectProduct=new Object[7];
        for(int i=0;i<getProducts.size();i++){
            objectProduct[0]=getProducts.get(i).getId_product();
            objectProduct[1]=getProducts.get(i).getName_product();
            objectProduct[2]=getProducts.get(i).getMark();
            objectProduct[3]=getProducts.get(i).getCategory();
            objectProduct[4]=getProducts.get(i).getStock();
            objectProduct[5]=soles.format(getProducts.get(i).getPrice());
            objectProduct[6]=getProducts.get(i).getDate_in();
            productCatalogue.addRow(objectProduct);
        }
        tableCatalogue.setModel(productCatalogue);
    }
    public void itemMarkSelecting(){
        decimalFormatSymbols.setCurrencySymbol("S/. ");
        ((DecimalFormat) soles).setDecimalFormatSymbols(decimalFormatSymbols);
        List<Products> getProducts= OutputProduct.getMarksProduct(boxMark.getSelectedItem().toString());
        productCatalogue= (DefaultTableModel) tableCatalogue.getModel();
        Object[] objectProduct=new Object[7];
        for(int i=0;i<getProducts.size();i++){
            objectProduct[0]=getProducts.get(i).getId_product();
            objectProduct[1]=getProducts.get(i).getName_product();
            objectProduct[2]=getProducts.get(i).getMark();
            objectProduct[3]=getProducts.get(i).getCategory();
            objectProduct[4]=getProducts.get(i).getStock();
            objectProduct[5]=soles.format(getProducts.get(i).getPrice());
            objectProduct[6]=getProducts.get(i).getDate_in();
            productCatalogue.addRow(objectProduct);
        }
        tableCatalogue.setModel(productCatalogue);
    }
    public void clearTable(){
        for (int i=0;i<productCatalogue.getRowCount();i++){
            productCatalogue.removeRow(i);
            i=i-1;
        }
    }
    public void initialRender(){
//        DefaultTableCellRenderer center=new DefaultTableCellRenderer();
//        center.setHorizontalAlignment(JLabel.CENTER);
//        tableCatalogue.getColumnModel().getColumn(0).setCellRenderer(center);
        DefaultTableCellRenderer center=new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        for (int columnIndex = 0; columnIndex < tableCatalogue.getColumnCount(); columnIndex++) {
            tableCatalogue.getColumnModel().getColumn(columnIndex).setCellRenderer(center);
        }
    }
    private void filterAnyElement(String consult, JTable jTableSearch) {
        DefaultTableModel dm;
        dm = (DefaultTableModel) jTableSearch.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jTableSearch.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consult));
    }
    private void placeHolderText() {
        PromptSupport.setPrompt("Buscador Producto", txtSearchProductCatalogue);
    }
}
