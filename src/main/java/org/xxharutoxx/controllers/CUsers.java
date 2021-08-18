package org.xxharutoxx.controllers;

import org.xxharutoxx.models.Users;

public class CUsers {
    public static Users createUsers(String users, String password, String fullNames, String phone,String address, String rol){
        Users save=new Users();
        save.setUsers(users);
        save.setPassword(password);
        save.setFullNames(fullNames);
        save.setPhone(phone);
        save.setAddress(address);
        save.setRol(rol);
        return save;
    }

    public static Users deleteFromUsers(int id_user){
        Users user=new Users();
        user.setId_users(id_user);
        return user;
    }
    public static Users updateFromUsers(String users, String password, String fullNames, String phone,String address, String rol){
        Users update=new Users();
        update.setUsers(users);
        update.setPassword(password);
        update.setFullNames(fullNames);
        update.setPhone(phone);
        update.setAddress(address);
        update.setRol(rol);
        return update;
    }
}
