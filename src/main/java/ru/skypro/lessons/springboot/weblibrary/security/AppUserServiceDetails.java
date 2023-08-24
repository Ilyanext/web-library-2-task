//package ru.skypro.lessons.springboot.weblibrary.security;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

//@Service
//public class AppUserServiceDetails implements UserDetailsService {
//    private final AppUserRepository repository;
//    private final AppUserMapper mapper;
//    private final AppUserDetalis appUserDetalis;
//
//
//    public AppUserServiceDetails(AppUserRepository repository, AppUserDetalis appUserDetalis, AppUserMapper mapper) {
//        this.repository = repository;
//        this.appUserDetalis = appUserDetalis;
//        this.mapper = mapper;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        var appUser = repository.findAppUserByLogin(username)
//                .orElseThrow(() -> new IllegalStateException("User not found"));
//        appUserDetalis.setUserDetalis(mapper.toDto(appUser));
//        return appUserDetalis;
//    }
//}
