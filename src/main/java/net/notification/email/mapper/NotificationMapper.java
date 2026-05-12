package net.notification.email.mapper;

import org.mapstruct.Mapper;

import net.notification.email.entity.Notification;
import net.notification.email.vo.NotificationVo;

@Mapper
public interface NotificationMapper {

	NotificationVo toVo(Notification notification);

	Notification toEntity(NotificationVo notificationVo);
}