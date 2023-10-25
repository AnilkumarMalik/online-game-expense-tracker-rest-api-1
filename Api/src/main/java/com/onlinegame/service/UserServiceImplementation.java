package com.onlinegame.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onlinegame.exception.AdminException;
import com.onlinegame.exception.UserException;
import com.onlinegame.modal.Admin;
import com.onlinegame.modal.User;
import com.onlinegame.repository.UserRepository;


@Service
public class UserServiceImplementation implements UserService {

	private UserRepository userRepository;
	
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Override
	public User findUserById(Integer userId) throws UserException {

		Optional<User> opt=userRepository.findById(userId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new UserException("User not found with id "+userId);
		
		
	}

	

}
