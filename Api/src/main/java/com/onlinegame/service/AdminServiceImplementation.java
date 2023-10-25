package com.onlinegame.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegame.exception.AdminException;
import com.onlinegame.modal.Admin;
import com.onlinegame.repository.AdminRepository;

@Service
public class AdminServiceImplementation implements AdminService {

	private AdminRepository adminRepository;
    @Autowired
	public AdminServiceImplementation(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin findAdminById(Integer adminId) throws AdminException {
		Optional<Admin> opt = adminRepository.findById(adminId);

		if (opt.isPresent()) {
			return opt.get();
		}
		throw new AdminException("User not found with id " + adminId);
	}

}
