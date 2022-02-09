package com.pinxixi.controller.admin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class AdminUserController {

    @PostMapping("/login")
    public String login() {
        return "success";
    }
}
