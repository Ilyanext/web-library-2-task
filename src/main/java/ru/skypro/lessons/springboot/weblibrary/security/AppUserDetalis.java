package ru.skypro.lessons.springboot.weblibrary.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Component
public class AppUserDetalis implements UserDetails {
private AppUserDto userDetalis;

    public void setUserDetalis(AppUserDto userDetalis) {
        this.userDetalis = userDetalis;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Optional.ofNullable(userDetalis)
                .map(AppUserDto::getRole)
                .map(role -> "ROLE_"+ role)
                .map(SimpleGrantedAuthority::new)
                .map(List::of)
                .orElse(Collections.emptyList());
    }

    @Override
    public String getPassword() {
        return Optional.ofNullable(userDetalis)
                .map(AppUserDto::getPassword)
                .orElse(null);
    }

    @Override
    public String getUsername() {
        return Optional.ofNullable(userDetalis)
                .map(AppUserDto::getLogin)
                .orElse(null);
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
