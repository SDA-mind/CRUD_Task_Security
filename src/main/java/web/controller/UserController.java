package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.service;

import java.util.List;

@Controller
public class UserController {
    @Qualifier("userServiceImpl")
    @Autowired
    service userService;
    @GetMapping(value = "/")
    public String getHomePage() {
        return "redirect:/admin/userlist";
    }

    @GetMapping(value = "/admin/userlist")
    public String getList(Model model) {
        List<User> userList = userService.allUsers();
        model.addAttribute(userList);
        return "/admin/userlist";
    }

    @GetMapping(value = "/user")
    public String userInfo( Model model) {
        return "user";
    }

    @GetMapping(value = "/admin/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        User editUser = userService.getById(id);
        model.addAttribute("editUser",editUser);
        return "/admin/edit";
    }

    @GetMapping(value = "/admin/add")
    public String addPage() {
        return "/admin/add";
    }

    @PostMapping(value = "/admin/edit")
    public String edit(@ModelAttribute("editUser") User user) {
        userService.edit(user);
        return "redirect:/admin/userlist";
    }

    @PostMapping(value = "/admin/add")
    public String add(User user) {
        userService.add(user);
        return "redirect:/admin/userlist";
    }

    @PostMapping(value = "/admin/delete")
    public String delete(User user) {
        userService.delete(user);
        return "redirect:/admin/userlist";
    }
}
