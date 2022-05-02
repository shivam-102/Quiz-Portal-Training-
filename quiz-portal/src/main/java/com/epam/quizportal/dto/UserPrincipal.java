package com.epam.quizportal.dto;

import com.epam.quizportal.entity.AuthGroup;
import com.epam.quizportal.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipal implements UserDetails {

    private User user;

    private List<AuthGroup> authGroupList;

    public UserPrincipal(User user,List<AuthGroup> authGroupList){
        super();
        this.user=user;
        this.authGroupList=authGroupList;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authGroupList==null){
            return Collections.emptySet();
        }

        Set<SimpleGrantedAuthority> grantedAuthorities=new HashSet<>();
        authGroupList.forEach(group->{
            grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthGroup()));
        });
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
