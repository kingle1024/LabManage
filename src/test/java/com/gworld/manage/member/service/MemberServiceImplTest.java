package com.gworld.manage.member.service;

import com.gworld.manage.member.entity.Member;
import com.gworld.manage.member.model.MemberInput;
import com.gworld.manage.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {
    @InjectMocks
    private MemberServiceImpl memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    void registerSuccess(){
        // given
        MemberInput memberInput = MemberInput.builder()
                .userId("test@naver.com")
                .name("test")
                .password("1234")
                .build();

        String encPassword = BCrypt.hashpw(memberInput.getPassword(), BCrypt.gensalt());
        Member member = Member.builder()
                .userId(memberInput.getUserId())
                .name(memberInput.getName())
                .password(encPassword)
                .profileImagePath("")
                .registerDate(LocalDateTime.now())
                .enabled(true)
                .isAdmin(false)
                .build();

        given(memberRepository.save(member))
                .willReturn(member);

        // when
        boolean register = memberService.register(memberInput);
//        then(memberService).should().register(memberInput);


//        assertEquals(2L, verify(memberRepository).save(member));

        // then
        assertEquals(true, register);
//        assertEquals(true, then(register).should());
    }
}