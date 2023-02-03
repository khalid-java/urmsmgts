package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	UserController(UserService userServic)  {
		this.userService=userService; 
	}
	//add
	@RequestMapping(path="/user",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<User> create(@RequestBody UserDto userDto) {
		User user = new User();
		user.setAddress(userDto.getAddress());
		user.setDob(userDto.getDob());
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setName(userDto.getName());
		User save = userService.save(user);
		return new ResponseEntity<User>(save, HttpStatus.CREATED);	
	}
	//find all 
	@RequestMapping(path = "/all",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<User>>  findAllPatient() {
		 List<User> allUser = userService.findAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}
	//find by Id
	@RequestMapping(path="/userId/{id}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<User> findByPatientId(@PathVariable Integer id) throws UserNotFoundException {
		User findById = userService.findById(id);
		return new ResponseEntity<User>(findById,HttpStatus.OK);
	}
	//update
	@RequestMapping(path = "/updatePatient/{id}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<User> updatePatient(@PathVariable Integer id,@RequestBody UserDto userDto) throws UserNotFoundException {
		User user = userService.updateUser(id, userDto);
		user.setAddress(userDto.getAddress());
		user.setDob(userDto.getDob());
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setName(userDto.getName());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	//delete by Id
	@RequestMapping(path = "/mod/{id}",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity deletePatient(@PathVariable Integer id) throws  UserNotFoundException{
		User deleteUser = userService.deletePatient(id);
		return new ResponseEntity (deleteUser,HttpStatus.OK);
	}

}
