package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoJpaService;

@RestController
public class TodoController {
    @Autowired
    public TodoJpaService apiService;

    @GetMapping("/todos")
    public ArrayList<Todo>  getAllTodos() {
        return apiService.getAllTodos();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return apiService.addTodo(todo);
    }

    @GetMapping("/todos/{todoId}")
    public Todo getTodoById(@PathVariable("todoId") int id) {
        return apiService.getTodoById(id);
    }

    @PutMapping("/todos/{todoId}")
    public Todo updateTodo(@PathVariable("todoId") int id, @RequestBody Todo todo) {
        return apiService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable("todoId") int id) {
        apiService.deleteTodo(id);
    }
}