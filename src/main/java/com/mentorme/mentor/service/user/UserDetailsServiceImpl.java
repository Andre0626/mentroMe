package com.mentorme.mentor.service.user;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.mentorme.mentor.entity.UserEntity;
import com.mentorme.mentor.repository.UserRepo;
import static com.mentorme.mentor.security.SecurityConstants.ROLE_PREFIX;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepo.findByEmail(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        //role
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + userEntity.getRole().getUserRole()));

        return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
    }
}
