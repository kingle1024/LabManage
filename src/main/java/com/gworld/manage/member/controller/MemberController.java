package com.gworld.manage.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    @RequestMapping("/member/login")
    public String login(){
        return "member/login";
    }
}
