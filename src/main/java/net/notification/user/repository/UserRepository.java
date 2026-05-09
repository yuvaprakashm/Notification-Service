package net.notification.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.notification.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
