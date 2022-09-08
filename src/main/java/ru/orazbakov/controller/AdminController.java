package ru.orazbakov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.orazbakov.model.User;
import ru.orazbakov.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsersInfoList(Model model, Principal principal) {

        model.addAttribute("authUser", userService.getUserByName(principal.getName()));
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("newUser", new User());

        return "admin";
    }

    @PostMapping("/save")
    public String getSaveUserForm(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String getUpdateUserForm(@ModelAttribute("user") User user) {
        userService.updateUserById(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String getRemoveUserForm(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

}
