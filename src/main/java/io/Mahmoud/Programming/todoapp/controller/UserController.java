package io.Mahmoud.Programming.todoapp.controller;

import io.Mahmoud.Programming.todoapp.entity.Todo;
import io.Mahmoud.Programming.todoapp.entity.User;
import io.Mahmoud.Programming.todoapp.repository.TodoRepository;
import io.Mahmoud.Programming.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.Mahmoud.Programming.todoapp.request.AddTodoRequest;
import io.Mahmoud.Programming.todoapp.request.AddUserRequest;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }
    @PostMapping
    public User addUser(@RequestBody AddUserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = new Todo();
        todo.setContent(todoRequest.getContent());
        user.getTodoList().add(todo);
        userRepository.save(user);
    }

    @PostMapping("/todos/{todoId}")
    public void toggleTodoCompleted( @PathVariable Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }


    @DeleteMapping("{userId}/todos/{todoId}")
    public void deleteTodo(@PathVariable Long userId,@PathVariable Long todoId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        user.getTodoList().remove(todo);
        todoRepository.delete(todo);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);
    }
}
