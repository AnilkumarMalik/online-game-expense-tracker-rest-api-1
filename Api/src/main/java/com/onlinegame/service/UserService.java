package com.onlinegame.service;


import com.onlinegame.exception.UserException;
import com.onlinegame.modal.User;


public interface UserService {
	
    public User findUserById(Integer userId) throws UserException;

	//Admin findAdminById(Integer adminId) throws AdminException;
	
//	public User updateUser(Integer userId, UpdateUserRequest req) throws UserException;
	
//	public List<User> searchUser(String query);

}
