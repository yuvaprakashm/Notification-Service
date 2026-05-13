package net.notification.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.notification.user.entity.User;
import net.notification.user.service.UserService;
import net.notification.user.vo.UserVo;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping
	public List<User> findAllUsers() {
		return userService.findAll();
	}
	
	@PostMapping
	public User createUser(@Valid @RequestBody UserVo userVo) {
		return userService.createUser(userVo);
	}
}
