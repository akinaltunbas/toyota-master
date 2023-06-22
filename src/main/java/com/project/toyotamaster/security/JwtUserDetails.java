package com.project.toyotamaster.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import com.project.toyotamaster.entities.Role;
import com.project.toyotamaster.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtUserDetails implements UserDetails {
	
	public Long id;
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	

	public JwtUserDetails(Long id, String username, String password, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public static JwtUserDetails create(User user) {
        return new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(),user.getRole());
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
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