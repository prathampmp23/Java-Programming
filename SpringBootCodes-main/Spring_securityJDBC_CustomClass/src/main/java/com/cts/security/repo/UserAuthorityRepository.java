package com.cts.security.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.security.model.UserAuthority;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {
	List<UserAuthority> findByUserUsername(String username);
}
