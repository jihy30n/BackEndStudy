package com.example.test.service.jwt;

import com.example.test.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class MemberDetailsImpl implements UserDetails {
    private final MemberEntity memberEntity;
    @Override
    @Transactional
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> memberRole = new ArrayList<>();
        memberRole.add(memberEntity.getMemberRole().toString());
        String authority = memberRole.toString();

        SimpleGrantedAuthority simpleAuthority = new SimpleGrantedAuthority(authority);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleAuthority);

        return authorities;
    }

    @Override
    public String getPassword() {
        return memberEntity.getEmail();
    }

    @Override
    public String getUsername() {
        return memberEntity.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
