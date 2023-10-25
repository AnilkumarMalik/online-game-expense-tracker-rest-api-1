package com.onlinegame.service;


import com.onlinegame.exception.AdminException;
import com.onlinegame.modal.Admin;

public interface AdminService {

	public Admin findAdminById(Integer adminId) throws AdminException;

	//public Admin findAdminProfile(String jwt) throws AdminException;

	//public Admin updateAdmin(Integer adminId, UpdateUserRequest req) throws AdminException;

	//public List<Admin> searchAdmin(String query);

}
