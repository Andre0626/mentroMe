package com.mentorme.mentor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    //private  LocalDateTime localDateTime =  LocalDateTime.now();

    @Id
    @Column(name ="id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "join_date", nullable = false)
    private LocalDateTime joinDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime updateDateUser;

    @Column(name = "password")
    private String password;

    @PrePersist
    private void onPrePersist(){
      setJoinDate(LocalDateTime.now());
    }

    @PreUpdate
    private void onPreUpdate(){
        setUpdateDateUser(LocalDateTime.now());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
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
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
