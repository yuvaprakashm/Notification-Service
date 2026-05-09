package net.notification.user.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import net.notification.user.entity.User;

@Getter
public class UserCreatedEvent extends ApplicationEvent {

	private final User user;

	public UserCreatedEvent(Object source, User user) {
		super(source);
		this.user = user;
	}
}
