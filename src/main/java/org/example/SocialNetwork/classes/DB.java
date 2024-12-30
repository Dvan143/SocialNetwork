package org.example.SocialNetwork.classes;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DB {
    List<User> dbList = new ArrayList<>();
    int id = 0;
    {
        dbList.add(new User("admin@gmail.com","admin","admin",id++));
        dbList.add(new User("user@gmail.com","user","user",id++));
        dbList.add(new User("user2@yandex.ru","user2","user2",id++));
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
    public String getEmailById(int id) {
        for (User user : dbList) {
            if (id == user.getId()) {
                return user.getEmail();
            }
        }
        return null;
    }
    public void resetPasswordByEmail(String mail) {
        for (User user : dbList) {
            if (mail.equals(user.getEmail())) {
                // do anything
            }
        }
    }
    public boolean passwordcheck(String name, String password) {
        for (User user : dbList) {
            if (name.equals(user.getName()) && password.equals(user.getPassword())) return true;
        }
        return false;
    }
    public void newUser(String mail, String name, String password) {
        dbList.add(new User(mail, name ,password, id++));
    }
    public boolean userExists(String name) {
        for (User user : dbList) {
            if (name.equals(user.getName())) {
                return true;
            }
        }
        return false;
    }
    public boolean emailExists(String email) {
        for (User user : dbList) {
            if (email.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
