package com.example.demo.servic.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> findAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User findById(Integer id) throws UserNotFoundException {
		Optional<User> findById = userRepo.findById(id);
		if(!findById.isPresent()) {
			throw new UserNotFoundException("Patient is not present");
		}else {
			return findById.get();
		}
		
	}

	@Override
	public User updateUser(Integer id, UserDto userDto) throws UserNotFoundException {
		User userDB = userRepo.findById(id).get();
		if(!userRepo.findById(id).isPresent()) {
			throw new UserNotFoundException("Patient is not present");
		} else {
			if(Objects.nonNull(userDto.getAddress()) && !"".contentEquals(userDto.getAddress())) {
				userDB.setAddress(userDto.getAddress());
			 }
			
			 if(Objects.nonNull(userDto.getDob()) && !"".equalsIgnoreCase(userDto.getDob())) {
				 userDB.setDob(userDto.getDob());
			 }
			 if(Objects.nonNull(userDto.getEmail()) && !"".equalsIgnoreCase(userDto.getEmail())) {
				 userDB.setEmail(userDto.getEmail());
			 }
			 if(Objects.nonNull(userDto.getGender()) && !"".equalsIgnoreCase(userDto.getGender())) {
				 userDB.setGender(userDto.getGender());
			 }
			 if(Objects.nonNull(userDto.getMobile())) {
				 userDB.setMobile(userDto.getMobile());
			 }
			 if(Objects.nonNull(userDto.getName()) && !"".equalsIgnoreCase(userDto.getName())) {
				 userDB.setName(userDto.getName());
			 } 
		}
		return userRepo.save(userDB);
	}

	@Override
	public User deletePatient(Integer id) throws UserNotFoundException {
		if(!userRepo.findById(id).isPresent()) {
			 throw new UserNotFoundException("Patient is not present");
		}else {
			return userRepo.findById(id).get();
		}
		
		
	}

	@Override
	public List<User> findAllPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
