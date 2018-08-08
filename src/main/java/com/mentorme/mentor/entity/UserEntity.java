package com.mentorme.mentor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import static com.mentorme.mentor.security.SecurityConstants.ROLE_PREFIX;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    @Column(name = "last_update")
    private LocalDateTime updateDataUser;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "characterPassword")
    private String characterPassword;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @PrePersist
    private void onPrePersist() {
        setJoinDate(LocalDateTime.now());
    }

    @PreUpdate
    private void onPreUpdate() {
        setUpdateDataUser(LocalDateTime.now());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + getRole().getUserRole()));

        return authorities;
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
