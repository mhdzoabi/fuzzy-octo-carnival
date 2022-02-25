package io.Mahmoud.Programming.todoapp;

import io.Mahmoud.Programming.todoapp.entity.Todo;
import io.Mahmoud.Programming.todoapp.entity.User;
import io.Mahmoud.Programming.todoapp.repository.TodoRepository;
import io.Mahmoud.Programming.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.descriptor.TaglibDescriptor;

@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User mahmoud = new User();
		mahmoud.setId(1L);
		mahmoud.setPassword("mahmoud on fire hashcode");
		mahmoud.setUsername("Mido");

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setContent("Upload Video to Youtube");

		mahmoud.getTodoList().add(todo);
		todoRepository.save(todo);
		userRepository.save(mahmoud);
	}

}
