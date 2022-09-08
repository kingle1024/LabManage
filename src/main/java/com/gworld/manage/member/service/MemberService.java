package com.gworld.manage.member.service;

import com.gworld.manage.member.entity.Member;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    Member detail(String name);
}
