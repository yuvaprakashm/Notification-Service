package net.notification.user.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo {

	@NotBlank
	private String name;

	@Email
	private String email;
}
