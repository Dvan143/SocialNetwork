package org.example.SocialNetwork.classes;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DB {
    List<User> dbList = new ArrayList<>();
    int id = 0;
    {
        dbList.add(new User("admin","admin",id++));
        dbList.add(new User("user","user",id++));
        dbList.add(new User("user2","user2",id++));
    }
    public String getUserById(int id) {
        for (User user : dbList) {
            if (id == user.getId()) {
                return user.getName();
            }
        }
        return null;
    }
    public String getIdByName(String name) {
        for (User user : dbList) {
            if (name.equals(user.getName())) {
                return String.valueOf(user.getId());
            }
        }
        return null;
    }
    public boolean passwordcheck(String name, String password) {
        for (User user : dbList) {
            if (name.equals(user.getName()) && password.equals(user.getPassword())) return true;
        }
        return false;
    }
    public void newUser(String name, String password) {
        dbList.add(new User(name,password,id++));
    }
    public boolean userExists(String name) {
        for (User user : dbList) {
            if (name.equals(user.getName())) {
                return true;
            }
        }
        return false;
    }
    //dodelat
    public boolean emailExists(String name) {
        for (User user : dbList) {
            if (email.equals(email.getName())) {
                return true;
            }
        }
        return false;
    }
//    public boolean emailExists(String mail) {
//        for (User user : dbList) {
//            if (mail.equals(user.getName())) {
//                return true;
//            }
//        }
//        return false;
//    }
}
