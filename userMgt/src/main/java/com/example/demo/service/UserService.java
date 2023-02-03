package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;

public interface UserService {
	public User save(User user);
	public List<User>  findAllPatient();
	public User findById(Integer id) throws UserNotFoundException  ;
	public User updateUser(Integer id, UserDto userDto) throws UserNotFoundException;
	public User deletePatient(Integer id) throws UserNotFoundException;
	public List<User> findAllUser();
}
