package org.example.socialnetwork;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/resetpassword")
    public String resetpassword() {
        return "resetpassword";
    }
    @GetMapping("settings")
    public String settings() {
        return "settings";
    }
}
