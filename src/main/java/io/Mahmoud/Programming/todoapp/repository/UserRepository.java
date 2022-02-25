package io.Mahmoud.Programming.todoapp.repository;

import io.Mahmoud.Programming.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
