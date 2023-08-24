package ru.skypro.lessons.springboot.weblibrary.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.lessons.springboot.weblibrary.pojo.AppUser;

import java.util.Optional;

public interface AppUserRepository  extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findAppUserByLogin (String Login);

}
