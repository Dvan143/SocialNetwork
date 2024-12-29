package org.example.SocialNetwork.controllers;

import org.example.SocialNetwork.classes.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    DB db;
    @Autowired
    public MainController(DB db) {
        this.db = db;
    }
    @GetMapping("/hi")
    public String index(Model model) {
        return "index";
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
    @GetMapping("profile/{id}")
    public String hello(@PathVariable("id") int id, Model model) {
        model.addAttribute("userName", db.getUserById(id));
        model.addAttribute("id", id);
        return "profile";
    }
    @PostMapping("resetPassword")
    public String resetPassword(@RequestParam("email") String email, Model model) {
        return "resetPassword";
    }
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }
    @PostMapping("registerUser")
    public String register(@RequestParam("email") String email,@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
        if(!db.userExists(userName)){
            db.newUser(userName, password);
            model.addAttribute("info", "User registered successfully");
        }else {
            model.addAttribute("info","User already exists");
        }
        return "register";
    }
}
