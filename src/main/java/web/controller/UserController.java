package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    @Qualifier("userUserServiceImpl")
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getHomePage() {
        return "redirect:/user";
    }

    @GetMapping(value = "/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping(value = "/user")
    public String userInfo(Model model, Authentication authentication) {
        if (authentication.isAuthenticated()) {
            User user = userService.getByName(authentication.getName());
            model.addAttribute("User", user);
        } else {
            model.addAttribute("User", new User());
        }
        return "user";
    }

}
