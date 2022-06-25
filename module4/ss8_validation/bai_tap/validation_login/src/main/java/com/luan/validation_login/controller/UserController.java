package com.luan.validation_login.controller;

import com.luan.validation_login.dto.UserDto;
import com.luan.validation_login.model.User;
import com.luan.validation_login.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    @GetMapping("")
    public String showUser(Model model) {
        model.addAttribute("listUser", userService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String showCreate(@ModelAttribute @Valid UserDto userDto,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("user", userDto);
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        this.userService.save(user);
        return "redirect:/user/";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("user",this.userService.getUser(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String getEdit(User user){
        this.userService.update(user);
        return "redirect:/user";
    }
    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id){
        userService.delete(id);
        return "redirect:/user";
    }
}
