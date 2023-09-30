package com.gworld.manage.controller;

import com.gworld.manage.common.model.ResponseResult;
import com.gworld.manage.member.entity.Member;
import com.gworld.manage.member.service.MemberService;
import com.gworld.manage.member.service.MemberServiceImpl;
import com.gworld.manage.model.ServiceResult;
import com.gworld.manage.service.NoticeService;
import com.gworld.manage.service.NoticeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@WebMvcTest
@ExtendWith(MockitoExtension.class)
class ApiNoticeControllerTest {
    @MockBean
    private NoticeServiceImpl noticeService;
    @MockBean
    private MemberServiceImpl memberService;


    @Autowired
    private MockMvc mockMvc;

    @Test
    void successDelete() throws Exception {
        Member member = Member.builder()
                        .isAdmin(false)
                        .build();
        given(memberService.detail("name"))
                .willReturn(member);


        // then
        mockMvc.perform(post("/api/notice/del.api"))
                .andExpect(jsonPath("$.result").value(false))
                .andDo(print());

    }
}