package net.notification.email.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.notification.email.entity.Notification;
import net.notification.email.repository.NotificationRepository;

@Service
@RequiredArgsConstructor
public class NotificationService {

	private final NotificationRepository notificationRepository;

	public List<Notification> getNotifications(Long userId) {
		return notificationRepository.findByUserId(userId);
	}

	public Notification markAsRead(Long notificationId) {

		Notification notification = notificationRepository.findById(notificationId)
		.orElseThrow(() -> new RuntimeException("Notification not found"));
		
		notification.setRead(true);
		
		return notificationRepository.save(notification);
	}
}
