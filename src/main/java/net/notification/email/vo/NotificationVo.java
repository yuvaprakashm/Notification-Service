package net.notification.email.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotificationVo {
	
	private Long id;
	private Long userId;
	private String message;
	private boolean isRead;
	private LocalDateTime createdAt;

}
