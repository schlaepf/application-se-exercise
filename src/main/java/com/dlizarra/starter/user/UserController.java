package com.dlizarra.starter.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dlizarra.starter.role.RoleName;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDto> findAll() {
		return userService.getUsers();
	}


//	@RequestMapping(value = "/user", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public void create(@RequestBody UserDto userDto) {
//		userService.createUser(userDto, RoleName.ROLE_USER);
//	}



}
