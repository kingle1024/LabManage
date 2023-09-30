package com.gworld.manage.member.service;

import com.gworld.manage.member.entity.Member;
import com.gworld.manage.member.model.MemberInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    Member detail(String name);

    boolean register(MemberInput parameter);
}
