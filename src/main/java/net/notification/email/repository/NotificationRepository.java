package net.notification.email.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.notification.email.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
	List<Notification> findByUserIdOrderByCreatedAtDesc(Long userId);
	
	List<Notification> findByUserIdAndIsReadOrderByCreatedAtDesc(Long userId, boolean isRead);
}
