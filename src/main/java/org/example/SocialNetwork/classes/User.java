package org.example.SocialNetwork.classes;

public class User {
    private String email;
    private String name;
    private String password;
    private int id;
    public User(String email, String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
}
