package com.cts.security.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.security.model.UserAccount;
import com.cts.security.repo.UserAccountRepository;
import com.cts.security.repo.UserAuthorityRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
 
	
    private final UserAccountRepository userRepo;
	private final UserAuthorityRepository authRepo;
 
    public CustomUserDetailsService(UserAccountRepository userRepo, UserAuthorityRepository authRepo) {
        this.userRepo = userRepo;
        this.authRepo = authRepo;
    }
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
 
        var authorities = authRepo.findByUserUsername(username).stream()
                .map(a -> new SimpleGrantedAuthority(a.getAuthority()))
                .collect(Collectors.toList());
 
        return User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .accountExpired(!user.isAccountNonExpired())
                .accountLocked(!user.isAccountNonLocked())
                .credentialsExpired(!user.isCredentialsNonExpired())
                .disabled(!user.isEnabled())
                .build();
    }
}
