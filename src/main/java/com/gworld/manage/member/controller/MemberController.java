package com.gworld.manage.member.controller;

import com.gworld.manage.member.model.MemberInput;
import com.gworld.manage.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;
    @RequestMapping("/member/login")
    public String login(){
        return "member/login";
    }
    @RequestMapping("/member/register")
    public String register(){
        return "member/register";
    }
}
