package org.xxharutoxx.models;

import org.xxharutoxx.connection.ConnectionSQlite;

import java.util.ArrayList;
import java.util.List;

public class Users extends ConnectionSQlite {

    private Integer id_users;
    private String users;
    private String password;
    private String fullNames;
    private String phone;
    private String address;
    private String rol;

    public Users() {
    }

    public Users(Integer id_users, String users, String password, String fullNames, String phone, String address, String rol) {
        this.id_users = id_users;
        this.users = users;
        this.password = password;
        this.fullNames = fullNames;
        this.phone = phone;
        this.address = address;
        this.rol=rol;
    }

    public Integer getId_users() {
        return id_users;
    }

    public void setId_users(Integer id_users) {
        this.id_users = id_users;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public static Users login(String email, String password){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select*from users_tbl where users=? and password=?");
            consulta.setString(1,email);
            consulta.setString(2,password);
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Users users=new Users();
                users.setId_users(resultado.getInt(1));
                users.setUsers(resultado.getString(2));
                users.setPassword(resultado.getString(3));
                users.setFullNames(resultado.getString(4));
                users.setPhone(resultado.getString(5));
                users.setAddress(resultado.getString(6));
                users.setRol(resultado.getString(7));
                return users;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return  null;
    }
    public boolean createNewUser(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("insert into users_tbl (users,password,fullNames,phone,address,rol) values (?,?,?,?,?,?)");
            consulta.setString(1,getUsers());
            consulta.setString(2,getPassword());
            consulta.setString(3,getFullNames());
            consulta.setString(4,getPhone());
            consulta.setString(5,getAddress());
            consulta.setString(6,getRol());
            return consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }

    public List<Users> listUsers(){
        List<Users> ListUsers=new ArrayList<>();
        try{
            openConexion();
            consulta=conexion.prepareStatement("select*from users_tbl");
            resultado=consulta.executeQuery();
            while (resultado.next()){
                Users users=new Users();
                users.setId_users(resultado.getInt(1));
                users.setUsers(resultado.getString(2));
                users.setPassword(resultado.getString(3));
                users.setFullNames(resultado.getString(4));
                users.setPhone(resultado.getString(5));
                users.setAddress(resultado.getString(6));
                users.setRol(resultado.getString(7));
                ListUsers.add(users);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return ListUsers;
    }

    public static Users getLastUser(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select id_users, users, password, fullNames, phone, address, rol from users_tbl where id_users=(select max(id_users)from users_tbl)");
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Users u=new Users();
                u.setId_users(resultado.getInt(1));
                u.setUsers(resultado.getString(2));
                u.setPassword(resultado.getString(3));
                u.setFullNames(resultado.getString(4));
                u.setPhone(resultado.getString(5));
                u.setAddress(resultado.getString(6));
                u.setRol(resultado.getString(7));
                return u;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return null;
    }
    public boolean deleteUsers(int id){
        try {
            openConexion();
            consulta=conexion.prepareStatement("delete from users_tbl where id_users=?");
            consulta.setInt(1,id);
            return consulta.execute();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }

    public boolean updateUsers(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("update users_tbl set users=?, password=?,fullNames=?,phone=?,address=?,rol=? where id_users=?");
            consulta.setString(1,getUsers());
            consulta.setString(2,getPassword());
            consulta.setString(3,getFullNames());
            consulta.setString(4,getPhone());
            consulta.setString(5,getAddress());
            consulta.setString(6,getRol());
            consulta.setInt(7,getId_users());
            return consulta.execute();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }


}
