package com.example.project.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Model.ApplicationUser;
import com.example.project.Model.Patient;
import com.example.project.security.JwtUtil;
import com.example.project.service.ApplicationUserService;
import com.example.project.service.UserAuthService;

@RestController
public class ApplicationUserController {
	@Autowired
	ApplicationUserService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserAuthService userDetailsService;
	
	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@RequestBody ApplicationUser applicationUser)
	{
		ApplicationUser user =  service.registeruser(applicationUser);
		if(user != null) {
			return new ResponseEntity<Object>(new responseBean("Registration successful"),HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new responseBean("Password or user_name policy failed"),HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUser_name(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUser_name());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token,authenticationRequest.getUser_name(),"Authontication successful"));
	}

	private void authenticate(String user_name, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user_name, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	
	@GetMapping("/viewprofile/{id}")
	public ApplicationUser fetchApplicationUser(@PathVariable String id)
	{
		return service.fetchapplicationuser(id);
	}
	
	@GetMapping("editprofile/{id}")
	public ApplicationUser editApplicationUser(@RequestBody ApplicationUser applicationUser)
	{
		return service.editapplicationuser(applicationUser);
	}

}
class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String user_name;
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String user_name, String password) {
		this.setUser_name(user_name);
		this.setPassword(password);
	}

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
	

class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private String token;
	private String id;
	private String message;
	
	
	public JwtResponse(String token, String userId, String message) {
		super();
		this.token = token;
		this.id = userId;
		this.message = message;
	}
	public String getUserId() {
		return id;
	}
	public void setUserId(String userId) {
		this.id = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getToken() {
		return token;
	}
	
}


