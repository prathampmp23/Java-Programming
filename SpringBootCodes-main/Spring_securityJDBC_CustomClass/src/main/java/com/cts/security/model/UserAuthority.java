package com.cts.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_authority")
public class UserAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    // e.g., ROLE_USER, ROLE_ADMIN
    @Column(nullable=false, length=100)
    private String authority;
 
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable=false)
    private UserAccount user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	public UserAuthority(Long id, String authority, UserAccount user) {
		super();
		this.id = id;
		this.authority = authority;
		this.user = user;
	}

	public UserAuthority() {
		super();
	}

	@Override
	public String toString() {
		return "UserAuthority [id=" + id + ", authority=" + authority + ", user=" + user + "]";
	}
    
    
}
