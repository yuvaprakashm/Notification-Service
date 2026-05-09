package net.notification.email.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.notification.email.entity.Notification;
import net.notification.email.service.NotificationService;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {
	
	private final NotificationService notificationService;
	
	@GetMapping("/{userId}")
	public List<Notification> getNotifications(@PathVariable Long userId){
		return notificationService.getNotifications(userId);
	}
	
	@PatchMapping("{notificationId}/read")
	public Notification markAsRead(@PathVariable Long notificationId) {
		return notificationService.markAsRead(notificationId);
	}
}
