package org.xxharutoxx.views.mainWindow;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.jdesktop.swingx.prompt.PromptSupport;
import org.xxharutoxx.controllers.CDescOutputProduct;
import org.xxharutoxx.controllers.COutputProduct;
import org.xxharutoxx.controllers.CProducts;
import org.xxharutoxx.models.DescOutputProduct;
import org.xxharutoxx.models.OutputProduct;
import org.xxharutoxx.models.Products;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

public class CancelOutput {
    private JPanel panelCancelOutput;
    private JTextField txtSearchAnyElement;
    private JTable tableCancelOutput;
    private JLabel lblIdProductCancel;
    private JLabel lblIdDescCancel;
    private JButton btnCancelOutput;
    private JComboBox boxProductCancelOutput;
    private JLabel lblQuantityCancel;
    private JButton EXPORTARREPORTESButton;
    private DefaultTableModel modelTableCancelOutput;
    private DescOutputProduct descOutputProduct;
    private OutputProduct outputProduct;
    private Products products;
    private final String title = "Anular Salida";
    private final String[] columnsTableCancelOutput = {"ID SALIDA", "ID DESC", "ID PRODUCTO", "NOMBRES", "PRODUCTO", "CATEGORÍA", "MARCA", "CANTIDAD", "FECHA"};
    private LocalDate fechaActual = LocalDate.now();


    public CancelOutput() {
        initComponents();
        getOutputProducts();
        initialRender();
        placeHolderText();
        tableCancelOutput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableCancelOutput.rowAtPoint(e.getPoint());
                boxProductCancelOutput.getModel().setSelectedItem(tableCancelOutput.getModel().getValueAt(row, 4).toString());
                lblIdProductCancel.setText(tableCancelOutput.getValueAt(row, 2).toString());
                lblIdDescCancel.setText(tableCancelOutput.getValueAt(row, 1).toString());
                lblQuantityCancel.setText(tableCancelOutput.getValueAt(row,7).toString());
            }
        });
        txtSearchAnyElement.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filterAnyElement(txtSearchAnyElement.getText(), tableCancelOutput);
            }
        });
        btnCancelOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableCancelOutput.getSelectedRow();
                if(row<0){
                    JOptionPane.showMessageDialog(null,"Seleccione una fila para anular");
                }else{
                    if(Integer.parseInt(tableCancelOutput.getModel().getValueAt(row,7).toString())<0){
                        JOptionPane.showMessageDialog(null,"Esa fila ya fue anulada");
                    }else{
                        cancelOutputProduct(row);
                        clearTable();
                    }
                }

            }
        });
        EXPORTARREPORTESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Document document= new Document();
                try {
                    String ruta=System.getProperty("user.home");
                    PdfWriter.getInstance(document,new FileOutputStream(ruta +"/Desktop/Reportes "+fechaActual+".pdf"));
                    document.open();
                    Font f=new Font(Font.FontFamily.TIMES_ROMAN,25.0f,Font.BOLD, BaseColor.BLACK);
                    Paragraph titulo=new Paragraph("REPORTE DE SALIDAS",f);
                    titulo.setAlignment(Element.ALIGN_CENTER);
                    Paragraph titulo1=new Paragraph("\n");
                    Paragraph titulo2=new Paragraph(" \n");
                    document.add(titulo);
                    document.add(titulo1);
                    document.add(titulo2);
                    PdfPTable table= new PdfPTable(4);
                    table.addCell("FECHA");
                    table.addCell("TRABAJADOR");
                    table.addCell("PRODUCTO");
                    table.addCell("CANTIDAD DE SALIDA");
                    List<String[]> registros = OutputProduct.getOutputProduct();
                    for(String[] re:registros){
                        table.addCell(re[8]);
                        table.addCell(re[3]);
                        table.addCell(re[4]);
                        table.addCell(re[7]);
                    }
                    document.add(table);
                    document.close();
                    JOptionPane.showMessageDialog(null,"reporte creado");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"cierre el pdf");
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanelCancelOutput() {
        return panelCancelOutput;
    }

    public String getTitle() {
        return title;
    }

    public void initComponents() {
        tableCancelOutput.setModel(new DefaultTableModel(null, columnsTableCancelOutput));
        modelTableCancelOutput = (DefaultTableModel) tableCancelOutput.getModel();
    }

    public void getOutputProducts() {
        List<String[]> getOutputProducts = OutputProduct.getOutputProduct();
        modelTableCancelOutput = (DefaultTableModel) tableCancelOutput.getModel();
        Object[] objectProduct = new Object[9];
        for (String[] output : getOutputProducts) {
            objectProduct[0] = output[0];
            objectProduct[1] = output[1];
            objectProduct[2] = output[2];
            objectProduct[3] = output[3];
            objectProduct[4] = output[4];
            objectProduct[5] = output[5];
            objectProduct[6] = output[6];
            objectProduct[7] = output[7];
            objectProduct[8] = output[8];
            modelTableCancelOutput.addRow(objectProduct);

        }
        tableCancelOutput.setModel(modelTableCancelOutput);
    }

    public void initialRender() {
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        for (int columnIndex = 0; columnIndex < tableCancelOutput.getColumnCount(); columnIndex++) {
            tableCancelOutput.getColumnModel().getColumn(columnIndex).setCellRenderer(center);
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
        PromptSupport.setPrompt("Buscador general", txtSearchAnyElement);
    }

    public void cancelOutputProduct(int row) {
        String name_user;
        String nameProduct;
        int quantityRow;
        int id_desc;
        int id_product;
        int id_output;

        try {
            int question = JOptionPane.showConfirmDialog(null, "¿Estas seguro de anular la salida?");
            if (question == 0) {
                name_user = tableCancelOutput.getModel().getValueAt(row, 3).toString();
                quantityRow = Integer.parseInt(tableCancelOutput.getModel().getValueAt(row, 7).toString());
                nameProduct = tableCancelOutput.getModel().getValueAt(row, 4).toString();
                id_desc = Integer.parseInt(tableCancelOutput.getModel().getValueAt(row, 1).toString());
                id_product = Integer.parseInt(tableCancelOutput.getModel().getValueAt(row, 2).toString());
                id_output = Integer.parseInt(tableCancelOutput.getModel().getValueAt(row, 0).toString());
                descOutputProduct = new DescOutputProduct(null, nameProduct, -quantityRow, id_output, id_product);
                descOutputProduct = CDescOutputProduct.CDeleteDescOutputProduct(id_desc);
                outputProduct = COutputProduct.CCreateOutputProduct(name_user);
                products = CProducts.CUpdateStockProductFromCancel(id_product, quantityRow);
                System.out.println("q " + quantityRow);
                System.out.println("id desc " + id_desc);
                System.out.println("id product " + id_product);
                System.out.println("id out " + id_output);
                System.out.println("name " + name_user);
                System.out.println("name product " + nameProduct);
                if (!products.updateStockProductCancel() && !descOutputProduct.deleteDescOutputProduct(id_desc) && !outputProduct.createOutputProduct()) {
                    JOptionPane.showMessageDialog(null, "Salida anulada con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no guardado");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Se canceló la anulación");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void clearTable(){
        for (int i=0;i<modelTableCancelOutput.getRowCount();i++){
            modelTableCancelOutput.removeRow(i);
            i=i-1;
        }
        getOutputProducts();
    }
}
