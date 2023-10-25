package com.onlinegame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onlinegame.modal.Admin;
import com.onlinegame.repository.AdminRepository;

@Service
public class CustomAdminService implements UserDetailsService {

	private AdminRepository adminRepository;

	public CustomAdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String adminName) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByEmail(adminName);

		if (admin == null) {
			throw new UsernameNotFoundException("Admin not found with username " + adminName);
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(),
				authorities);
	}

}
