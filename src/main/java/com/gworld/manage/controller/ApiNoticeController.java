package com.gworld.manage.controller;

import com.gworld.manage.common.model.ResponseResult;
import com.gworld.manage.member.entity.Member;
import com.gworld.manage.member.service.MemberService;
import com.gworld.manage.model.BoardDto;
import com.gworld.manage.model.ServiceResult;
import com.gworld.manage.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class ApiNoticeController {
    private final NoticeService noticeService;
    private final MemberService memberService;
    @PostMapping("/api/notice/del.api")
    public ResponseEntity<?> del(
            @RequestBody BoardDto boardDto, Principal principal
    ){
        Member member = memberService.detail(principal.getName());
        ResponseResult responseResult;
        ServiceResult result = new ServiceResult();
        if(!member.isAdminYn()){
            result.setMessage("관리자가 아닙니다.");
            result.setResult(false);
            responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(responseResult);
        }

        result = noticeService.delete(boardDto.getId());
        if(!result.isResult()){
            responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(responseResult);
        }

        responseResult = new ResponseResult(true);
        return ResponseEntity.ok().body(responseResult);
    }
}
