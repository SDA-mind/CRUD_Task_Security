package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @GetMapping(name = "/")
    public String getList(Model model) {
        List<User> userList = userService.allUsers();
        model.addAttribute(userList);
        return "userlist";
    }
    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        User editUser = userService.getById(id);
        model.addAttribute("editUser",editUser);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute("editUser") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @PostMapping(value = "/add")
    public String add(User user) {
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String delete(User user) {
        userService.delete(user);
        return "redirect:/";
    }
}
