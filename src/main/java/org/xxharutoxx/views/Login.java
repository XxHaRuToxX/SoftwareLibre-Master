package org.xxharutoxx.views;

import org.xxharutoxx.models.Users;
import org.xxharutoxx.views.mainWindow.Principal;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame{
    private JPanel panelLogin;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private Users users;

    public Login(){
        initComponent();
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUsers();
            }
        });
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                onCancel();
//                Principal p=new Principal(Users.login("worker","12345"));
//                p.setVisible(true);
//            }
//        });
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginUsers();
                }
            }
        });

    }

    public void initComponent(){
        setContentPane(panelLogin);
        setSize(500,350);
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public void loginUsers(){
        String user= txtUser.getText();
        String password_user= txtPassword.getText();
        users= Users.login(user,password_user);
        try{
            if(validateSpaces()){
                if(users!=null){
                    Principal p=new Principal(users);
                    p.setVisible(true);
                    dispose();
                    System.out.println("SI llega aqui");
                }else{
                    JOptionPane.showMessageDialog(null,"Contraseña o Usuario son incorrectos");
                    cleanControls();
                }

            }else{
                JOptionPane.showMessageDialog(null,"Por Favor Complete los espacios");
                cleanControls();

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private boolean validateSpaces(){
        String user= txtUser.getText();
        String password= txtPassword.getText();
        if(user.length()>0&&password.length()>0){
            return true;
        }else{
            return false;
        }
    }
    private void cleanControls(){
        txtUser.setText(null);
        txtPassword.setText(null);

    }

//    private void onCancel() {
//        // add your code here if necessary
//        dispose();
//    }
}
