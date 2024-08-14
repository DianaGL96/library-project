package ru.itgirl.library_project.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itgirl.library_project.model.MyUser;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetailsImpl implements UserDetails {
    private Long id;
    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public MyUserDetailsImpl(Long id, String login, String password, Collection<? extends GrantedAuthority> authorities){
        this.id = id;
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    public static MyUserDetailsImpl build(MyUser myUser){
        List<GrantedAuthority>authoritiesList = myUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
                .collect(Collectors.toList());
        return new MyUserDetailsImpl(myUser.getId(),
        myUser.getLogin(),
        myUser.getPassword(),
        authoritiesList);
    }

    @Override
    public Collection<? extends GrantedAuthority>getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
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
