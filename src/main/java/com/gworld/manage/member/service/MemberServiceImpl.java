package com.gworld.manage.member.service;

import com.gworld.manage.member.entity.Member;
import com.gworld.manage.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optionalMember = memberRepository.findById(username);
        if(optionalMember.isEmpty()){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }
        Member member = optionalMember.get();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if(member.isAdminYn()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return new User(member.getUserId(), member.getPassword(), grantedAuthorities);
    }

    @Override
    public Member detail(String name) {
        Optional<Member> optionalMember = memberRepository.findById(name);
        return optionalMember.orElse(null);
    }
}
