package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.service;

import java.util.List;

@Controller
public class AdminController {
    @Qualifier("userServiceImpl")
    @Autowired
    service userService;

    @GetMapping(value = "/admin/userlist")
    public String getList(Model model) {
        List<User> userList = userService.allUsers();
        model.addAttribute("userList", userList);
        return "/admin/userlist";
    }

    @GetMapping(value = "/admin/edit/{name}")
    public String editPage(@PathVariable("name") String name, Model model) {
        User editUser = userService.getByName(name);
        model.addAttribute("editUser", editUser);
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

    @GetMapping(value = "/admin/delete/{name}")
    public String delete(@PathVariable("name") String name) {
        User user = userService.getByName(name);
        userService.delete(user);
        return "redirect:/admin/userlist";
    }
}