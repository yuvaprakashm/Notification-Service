package net.notification.email.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.notification.email.entity.Notification;
import net.notification.email.service.NotificationService;
import net.notification.email.vo.NotificationVo;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {
	
	private final NotificationService notificationService;
	
	@GetMapping
	public List<Notification> findAllNotifications() {
		return notificationService.findAll();
	}

	@GetMapping("/user/{userId}")
	public List<NotificationVo> getNotifications(@PathVariable Long userId,
			@RequestParam(required = false) Boolean read) {
		return notificationService.getNotifications(userId, read);
	}
	
	@PatchMapping("{notificationId}/read")
	public NotificationVo markAsRead(@PathVariable Long notificationId) {
		return notificationService.markAsRead(notificationId);
	}
}
