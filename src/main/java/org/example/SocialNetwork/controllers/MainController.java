package org.example.SocialNetwork.controllers;

import org.example.SocialNetwork.classes.DB;
import org.example.SocialNetwork.classes.NewsDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
    DB db;
    NewsDB newsDB;

    @Autowired
    public MainController(DB db, NewsDB newsDB) {
        this.db = db;
        this.newsDB = newsDB;
    }

    @GetMapping("/hi")
    public String index() {
        return "index";
    }
    @GetMapping("/profile/{id}")
    public String hello(@PathVariable("id") int id, Model model) {
        model.addAttribute("userName", db.getUserById(id));
        model.addAttribute("email", db.getEmailById(id));
        return "profile";
    }
    @GetMapping("/resetPassword")
    public String resetPassword() {
        return "resetPassword";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("allNews",newsDB.getNewsList()[0]);
        model.addAttribute("lastNews", newsDB.getNewsList()[1]);
        return "news";
    }
}
