package net.notification.user.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.notification.user.entity.User;
import net.notification.user.event.UserCreatedEvent;
import net.notification.user.repository.UserRepository;
import net.notification.user.vo.UserVo;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final ApplicationEventPublisher publisher;
	
	public User createdUser(UserVo userVo) {

		User user = User.builder().name(userVo.getName()).email(userVo.getEmail()).build();

		User savedUser = userRepository.save(user);

		publisher.publishEvent(new UserCreatedEvent(this, savedUser));

		return savedUser;
	}
}
