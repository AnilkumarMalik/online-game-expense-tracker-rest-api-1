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
import com.onlinegame.exception.UserException;
import com.onlinegame.modal.User;
import com.onlinegame.repository.UserRepository;
import com.onlinegame.request.LoginRequest;
import com.onlinegame.response.AuthResponse;
import com.onlinegame.service.CustomUserService;



@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	private CustomUserService customUserService;


	public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider ,CustomUserService customUserService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
		this.customUserService = customUserService;
	}

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler( @RequestBody User user) throws UserException {

		String email = user.getEmail();
		String full_name = user.getFull_name();
		String password = user.getPassword();
		String mobile=user.getMobile();

		User isUser = userRepository.findByEmail(email);

		// Check if user with the given email already exists
		if (isUser != null) {

			throw new UserException("Email Is Already Used With Another Account " + email);
		}

		// Create new user
		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setFull_name(full_name);
		createdUser.setMobile(mobile);
		createdUser.setPassword(passwordEncoder.encode(password));
		userRepository.save(createdUser);

//	        System.out.println("----- "+userRepository.save(createdUser).getName());
		// Authenticate user and generate JWT token
		Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtTokenProvider.generateJwtToken(authentication);

		AuthResponse res = new AuthResponse(jwt, true);

		//res.setAuth(true);
		//res.setJwt(jwt);

		return new ResponseEntity<AuthResponse>(res, HttpStatus.OK);
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

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserService.loadUserByUsername(username);
         
		System.out.println("sign in userDetails - " + userDetails);

		if (userDetails == null) {
			System.out.println("sign in userDetails - null " + userDetails);
			throw new BadCredentialsException("Invalid username or password");
		}
		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			System.out.println("sign in userDetails - password not match " + userDetails);
			throw new BadCredentialsException("Invalid username or password");
		}
		//Todo: Update the timestamp 
		//userRepository.updateTimeByEmail(username);
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}

}
