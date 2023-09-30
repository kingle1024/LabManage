package com.gworld.manage.member.controller;

import com.gworld.manage.common.model.ResponseResult;
import com.gworld.manage.member.model.MemberInput;
import com.gworld.manage.member.service.MemberService;
import com.gworld.manage.model.ServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ApiMemberController {
    private final MemberService memberService;
    @PostMapping("/api/member/register")
    public ResponseEntity<?> register(
            @RequestBody @Valid MemberInput parameter){

        ResponseResult responseResult;
        ServiceResult result = new ServiceResult();
        if(!parameter.getPassword().equals(parameter.getRePassword())){
            result.setMessage("비밀번호를 다시 확인해주세요.");
            responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(responseResult);
        }

        boolean register = memberService.register(parameter);
        if(!register){
            result.setMessage("유저 생성에 실패했습니다.");
            responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(responseResult);
        }

        responseResult = new ResponseResult(true);
        return ResponseEntity.ok().body(responseResult);
    }
}
