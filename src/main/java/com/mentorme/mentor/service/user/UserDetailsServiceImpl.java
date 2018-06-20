package com.mentorme.mentor.service.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.mentorme.mentor.entity.UserEntity;
import com.mentorme.mentor.repository.UserRepo;
import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepo userRepo;

    public UserDetailsServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{

        UserEntity userEntity = userRepo.findByUsername(username);

        if (userEntity == null) {
            throw  new UsernameNotFoundException(username);
        }

        return new User(userEntity.getName(), userEntity.getPassword(),emptyList());
    }
}
