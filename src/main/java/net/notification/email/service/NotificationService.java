package net.notification.email.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.notification.email.entity.Notification;
import net.notification.email.exception.ResourceNotFoundException;
import net.notification.email.mapper.NotificationMapper;
import net.notification.email.repository.NotificationRepository;
import net.notification.email.vo.NotificationVo;

@Service
@RequiredArgsConstructor
public class NotificationService {

	private final NotificationRepository notificationRepository;

	private final NotificationMapper notificationMapper;

	@Transactional(readOnly = true)
	public List<NotificationVo> getNotifications(Long userId, Boolean read) {

		List<Notification> notifications;
		if (read != null) {
			notifications = notificationRepository.findByUserIdAndIsReadOrderByCreatedAtDesc(userId, read);
		} else {
			notifications = notificationRepository.findByUserIdOrderByCreatedAtDesc(userId);
		}
		return notifications.stream().map(notificationMapper::toVo).collect(Collectors.toList());
	}

	public NotificationVo markAsRead(Long notificationId) {

		Notification notification = notificationRepository.findById(notificationId)
				.orElseThrow(() -> new ResourceNotFoundException("Notification not found"));
		notification.setRead(true);
		return notificationMapper.toVo(notificationRepository.save(notification));
	}
}
