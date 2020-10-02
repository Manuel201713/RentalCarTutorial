package com.rentcar.webapp.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetail extends User implements UserDetails{
	
	private static final String ROLE_ADMIN = "ROLE_ADMIN";
	private static final String ROLE_USER = "ROLE_USER";
	
	private final Set<GrantedAuthority> authorities;
	
	public CustomUserDetail(User user) {
		super(user);
		this.authorities = new HashSet<>();
		this.authorities.add(new SimpleGrantedAuthority(ROLE_USER));
		if(this.isAdmin())
			this.authorities.add(new SimpleGrantedAuthority(ROLE_ADMIN));		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getUsername() {
		return super.getEmail();
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
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
