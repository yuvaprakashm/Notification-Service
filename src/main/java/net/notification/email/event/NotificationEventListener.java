package net.notification.email.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.notification.email.entity.Notification;
import net.notification.email.enums.NotificationType;
import net.notification.email.repository.NotificationRepository;
import net.notification.email.service.EmailService;
import net.notification.user.entity.User;
import net.notification.user.event.UserCreatedEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationEventListener {

	private final NotificationRepository notificationRepository;
	private final EmailService emailService;

	@Async
	@EventListener
	public void handleUserCreatedEvent(UserCreatedEvent event) {

		User user = event.getUser();
		Notification notification = Notification.builder().userId(user.getId())
				.message("Welcome " + user.getEmail() + "! Your Account has been created Sucessfully.")
				.type(NotificationType.EMAIL).isRead(false).build();
		notificationRepository.save(notification);
		emailService.sendEmail(user.getEmail(), "Welcome",
				"Hello " + user.getName() + ", your account has been created successfully.");
		log.info("Notification created for user: {}", user.getId());
	}
}
