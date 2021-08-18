package org.xxharutoxx.views;

import org.xxharutoxx.controllers.CUsers;
import org.xxharutoxx.models.Users;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class NewUser extends JDialog {
    private JPanel panelNewUser;
    private JButton btnSaveNewUser;
    private JButton buttonCancel;
    private JTextField txtNewFullNames;
    private JTextField txtNewUsers;
    private JTextField txtNewPassword;
    private JTextField txtNewPhone;
    private JTable tableNewUsers;
    private JTextField txtNewAddress;
    private JComboBox boxNewRol;
    private JButton btnDeleteNewUser;
    private JButton btnUpdateNewUser;
    private JButton btnCleanControlNewUser;
    private Users users;
    private DefaultTableModel NewUsers;
    private String[] columnsTableNewUsers={"ID","NOMBRES","USUARIO","CONTRASEÑA","TELÉFONO","DIRECCIÓN","ROL"};

    public NewUser() {
        initComponent();
        setModal(true);
        getRootPane().setDefaultButton(btnSaveNewUser);
        getUsers();


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        panelNewUser.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        btnSaveNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateSpaces()){
                    int question=JOptionPane.showConfirmDialog(null,"¿Está seguro de Agregar?");
                    if(question==0){
                        createNewUsers();
                        Users lastUser=Users.getLastUser();
                        Object[] newUser=new Object[7];
                        newUser[0]=lastUser.getId_users();
                        newUser[1]=lastUser.getFullNames();
                        newUser[2]=lastUser.getUsers();
                        newUser[3]=lastUser.getPassword();
                        newUser[4]=lastUser.getPhone();
                        newUser[5]=lastUser.getAddress();
                        newUser[6]=lastUser.getRol();
                        NewUsers.addRow(newUser);
                        tableNewUsers.setModel(NewUsers);

                    }else{
                        JOptionPane.showMessageDialog(null,"se cancelo el registro");
                        cleanControls();
                    }

                }else {
                    JOptionPane.showMessageDialog(null,"Complete los espacios requeridos");
                }
            }
        });
        btnDeleteNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tableNewUsers.getSelectedRow();
                System.out.println(row);
                if(row<0){
                    JOptionPane.showMessageDialog(null,"Seleccione una fila de tabla para eliminar");
                }else{
                    deleteNewUsers(row);
                }

            }
        });
        tableNewUsers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=tableNewUsers.rowAtPoint(e.getPoint());
                txtNewFullNames.setText(tableNewUsers.getValueAt(row,1).toString());
                txtNewUsers.setText(tableNewUsers.getValueAt(row,2).toString());
                txtNewPassword.setText(tableNewUsers.getValueAt(row,3).toString());
                txtNewPhone.setText(tableNewUsers.getValueAt(row,4).toString());
                txtNewAddress.setText(tableNewUsers.getValueAt(row,5).toString());
                boxNewRol.setSelectedItem(tableNewUsers.getValueAt(row,6).toString());
            }
        });
        btnUpdateNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tableNewUsers.getSelectedRow();
                System.out.println(row);
                if(row<0){
                    JOptionPane.showMessageDialog(null,"Seleccione una fila de tabla para actualizar");
                }else{
                    updateNewUsers();
                }
            }
        });
        btnCleanControlNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanControls();
            }
        });
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public void initComponent(){
        setContentPane(panelNewUser);
        setSize(550,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        tableNewUsers.setModel(new DefaultTableModel(null,columnsTableNewUsers));
        NewUsers= (DefaultTableModel) tableNewUsers.getModel();
    }
    public void createNewUsers(){
        String new_user=txtNewUsers.getText();
        String new_password=txtNewPassword.getText();
        String new_fullNames=txtNewFullNames.getText();
        String new_phone=txtNewPhone.getText();
        String new_address=txtNewAddress.getText();
        String new_rol= boxNewRol.getSelectedItem().toString();
        users= CUsers.createUsers(new_user,new_password,new_fullNames,new_phone,new_address,new_rol);
        try{
            if(!users.createNewUser()){
                JOptionPane.showMessageDialog(null,"Registro realizado");
                cleanControls();
            }else{
                JOptionPane.showMessageDialog(null,"no se REgistro usuario");
                cleanControls();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void cleanControls(){
        txtNewUsers.setText(null);
        txtNewPassword.setText(null);
        txtNewFullNames.setText(null);
        txtNewPhone.setText(null);
        txtNewAddress.setText(null);

    }
    private boolean validateSpaces(){
        String new_user=txtNewUsers.getText();
        String new_password=txtNewPassword.getText();
        String new_fllNames=txtNewFullNames.getText();
        String new_phone=txtNewPhone.getText();
        String new_address=txtNewAddress.getText();
        String new_rol=boxNewRol.getSelectedItem().toString();
        if(new_user.length()>0 &&new_password.length()>0&&new_fllNames.length()>0&&new_phone.length()>0 && new_address.length()>0 && new_rol.length()>0){
            return true;
        }else{
            return false;
        }
    }

    public void getUsers(){
        Users listUser=new Users();
        List<Users> getUser=listUser.listUsers();
        NewUsers= (DefaultTableModel) tableNewUsers.getModel();

        Object[]obj=new Object[7];
        for(int i=0;i<getUser.size();i++){
            obj[0]=getUser.get(i).getId_users();
            obj[1]=getUser.get(i).getFullNames();
            obj[2]=getUser.get(i).getUsers();
            obj[3]=getUser.get(i).getPassword();
            obj[4]=getUser.get(i).getPhone();
            obj[5]=getUser.get(i).getAddress();
            obj[6]=getUser.get(i).getRol();
            NewUsers.addRow(obj);
        }
        tableNewUsers.setModel(NewUsers);
    }

    public void deleteNewUsers(int row){
        String cell=tableNewUsers.getModel().getValueAt(row,0).toString();
        users=CUsers.deleteFromUsers(Integer.parseInt(cell));
        try {
            int question = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminarlo?");

            if (question == 0) {
                if (!users.deleteUsers(Integer.parseInt(cell))){
                    JOptionPane.showMessageDialog(null, "eliminado");
                    cleanControls();
                    clearTable();
                } else {
                    JOptionPane.showMessageDialog(null,"no se eliminó");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Se canceló la eliminación");
                cleanControls();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void clearTable(){
        for (int i=0;i<NewUsers.getRowCount();i++){
            NewUsers.removeRow(i);
            i=i-1;
        }
        getUsers();
    }
    private void showData(){
        txtNewFullNames.setText(String.valueOf(users.getFullNames()));
        txtNewUsers.setText(users.getUsers());
        txtNewPassword.setText(users.getPassword());
        txtNewPhone.setText(users.getPhone());
        txtNewAddress.setText(users.getAddress());

    }

    public void updateNewUsers(){
        int row=tableNewUsers.getSelectedRow();
        String cell=tableNewUsers.getModel().getValueAt(row,0).toString();
        users= CUsers.updateFromUsers(txtNewUsers.getText(),txtNewPassword.getText(),txtNewFullNames.getText(),txtNewPhone.getText(),txtNewAddress.getText(),boxNewRol.getSelectedItem().toString());
        users.setId_users(Integer.parseInt(cell));
//        System.out.println(client);
        try{
            int question = JOptionPane.showConfirmDialog(null, "¿Estas seguro de actualizar?");
            if(question==0){
                if (users != null) {
                    JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                    users.updateUsers();
                    cleanControls();
                    clearTable();
                } else {
                    JOptionPane.showMessageDialog(null, "No se actualizó");
                }
            }else{
                JOptionPane.showMessageDialog(null,"se cancelo la actualización");
                cleanControls();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


//        System.exit(0);
}
