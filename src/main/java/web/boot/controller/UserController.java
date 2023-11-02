package web.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.boot.model.User;
import web.boot.service.UserService;

@Controller
//@RequestMapping("/templates")
public class UserController {



    private final UserService userService;
    @Autowired
    public UserController (UserService userService){

        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "user";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.showUser(id));
        return "edit_user";
    }

    @PatchMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUsers(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
