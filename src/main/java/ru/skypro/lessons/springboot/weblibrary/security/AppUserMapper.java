package ru.skypro.lessons.springboot.weblibrary.security;

import org.springframework.stereotype.Component;
import ru.skypro.lessons.springboot.weblibrary.pojo.AppUser;

@Component
public class AppUserMapper {
    public AppUserDto toDto(AppUser user) {
        AppUserDto userDto = new AppUserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }

}
