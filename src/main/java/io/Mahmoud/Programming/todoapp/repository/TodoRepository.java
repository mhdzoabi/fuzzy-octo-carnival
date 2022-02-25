package io.Mahmoud.Programming.todoapp.repository;

import io.Mahmoud.Programming.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
