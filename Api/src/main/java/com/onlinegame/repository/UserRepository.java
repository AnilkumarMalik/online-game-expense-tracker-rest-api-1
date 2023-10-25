package com.onlinegame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinegame.modal.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	

	public User findByEmail(String email);
	//public User findByMobile(String mobile);
	//@Modifying
	//@Query("UPDATE User u SET u.timeStamp = CURRENT_TIMESTAMP WHERE u.email = :email")
	//public int updateTimeByEmail(@Param("email") String email); 
	
	//@Query("SELECT u FROM User u WHERE u.full_name LIKE %:name%")
	//public  List<User> searchUser(@Param("name") String name);
	
	
	

}
