package com.onlinegame.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.onlinegame.modal.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	
	public Admin findByEmail(String email);
	//public User findByMobile(String mobile);
	
	@Query("SELECT a FROM Admin a WHERE a.full_name LIKE %:name%")
	public  List<Admin> searchAdmin(@Param("name") String name);

	public Optional<Admin> findById(Integer adminId);

}
