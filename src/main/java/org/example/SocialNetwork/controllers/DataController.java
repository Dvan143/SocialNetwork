package org.example.SocialNetwork.controllers;

import org.example.SocialNetwork.classes.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {
    DB db;
    @Autowired
    public DataController(DB db) {
        this.db = db;
    }
    @PostMapping("/registerUser")
    public String register(@RequestParam("email") String email, @RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
        if(db.userExists(userName)){
            model.addAttribute("info","User already exists");
        } else if (db.emailExists(email)) {
            model.addAttribute("info","Email already exists");
        } else {
            model.addAttribute("info","User already exists");
            db.newUser(email, userName, password);
            model.addAttribute("info", "User registered successfully");
        }
        return "register";
    }
    @PostMapping("/auth")
    public String userPanel(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
        if(!db.passwordcheck(userName,password)){
            model.addAttribute("error","Invalid password");
        }else{
            return "redirect:/profile/" + db.getIdByName(userName);
        }
        return "index";
    }
    @PostMapping("/resetMyPassword")
    public String resetingPassword(@RequestParam("email") String email, Model model){
        if(db.emailExists(email)){
            db.resetPasswordByEmail(email);
            model.addAttribute("info","Message has been sent");
        } else {
            model.addAttribute("info","Email does not exist");
        }
        return "resetPassword";
    }
}
