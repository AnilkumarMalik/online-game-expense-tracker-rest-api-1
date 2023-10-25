package com.onlinegame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegame.config.JwtTokenProvider;
import com.onlinegame.request.LoginRequest;
import com.onlinegame.response.AuthResponse;
import com.onlinegame.service.CustomAdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	

	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	private CustomAdminService customAdminService;


	public AdminController(PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider ,CustomAdminService customAdminService) {
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
		this.customAdminService = customAdminService;
	}
	
	
	
	
	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> loginHandler(@RequestBody LoginRequest req) {
		String email = req.getEmail();
		String password = req.getPassword();

		System.out.println(email + " ----- " + password);

		Authentication authentication = authenticate(email, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtTokenProvider.generateJwtToken(authentication);
		AuthResponse res = new AuthResponse(jwt, true);

		//res.setAuth(true);
		//es.setJwt(jwt);

		return new ResponseEntity<AuthResponse>(res, HttpStatus.OK);
	}

	private Authentication authenticate(String adminName, String password) {
		UserDetails adminDetails = customAdminService.loadUserByUsername(adminName);
         
		System.out.println("sign in userDetails - " + adminDetails);

		if (adminDetails == null) {
			System.out.println("sign in userDetails - null " + adminDetails);
			throw new BadCredentialsException("Invalid username or password");
		}
		if (!passwordEncoder.matches(password, adminDetails.getPassword())) {
			System.out.println("sign in AdminDetails - password not match " + adminDetails);
			throw new BadCredentialsException("Invalid username or password");
		}
		//Todo: Update the timestamp 
		//userRepository.updateTimeByEmail(username);
		return new UsernamePasswordAuthenticationToken(adminDetails, null, adminDetails.getAuthorities());
	}

}

