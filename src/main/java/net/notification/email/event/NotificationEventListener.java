package net.notification.email.event;

import java.time.LocalDateTime;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.notification.email.entity.Notification;
import net.notification.email.repository.NotificationRepository;
import net.notification.user.entity.User;
import net.notification.user.event.UserCreatedEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationEventListener {

	private final NotificationRepository notificationRepository;
	
	@EventListener
	public void handleUserCreatedEvent(UserCreatedEvent event) {

		User user = event.getUser();

		Notification notification = Notification.builder().userId(user.getId())
				.message("Welcome " + user.getEmail() + "! Your Account has been created Sucessfully.").isRead(false)
				.createdAt(LocalDateTime.now()).build();

		notificationRepository.save(notification);

		log.info("Notification created for user: {}", user.getId());
	}
}
