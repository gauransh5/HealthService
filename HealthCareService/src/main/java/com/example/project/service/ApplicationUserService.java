package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.json.simple.JSONObject;

import com.example.project.Model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import com.example.project.security.JwtUtil;

import net.bytebuddy.asm.Advice.Return;

@Service
public class ApplicationUserService {
	@Autowired
	ApplicationUserRepository repo;
	
	@Autowired
	JwtUtil jwtUtil;

	public ApplicationUser fetchapplicationuser(String id) {
		return repo.findById(id).get();
	}

	public ApplicationUser editapplicationuser(ApplicationUser applicationUser) {
		return repo.save(applicationUser);
	}

	public ApplicationUser registeruser(ApplicationUser applicationUser) {
		System.out.println(applicationUser.getUser_name());
		return repo.save(applicationUser);
	}
	
}


