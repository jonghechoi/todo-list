package com.example.todolist.controller.todo;

import com.example.todolist.domain.todo.TodoList;
import com.example.todolist.service.todo.TodoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/todolists")
public class TodoRestController {
    private final TodoServiceImpl todoService;

    public TodoRestController(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }

    // Create
    @PostMapping("/todolist")
    public ResponseEntity<Boolean> createTodoList(@PathVariable TodoList todoList) {
        if(todoService.createTodoList(todoList))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    // Read
    @GetMapping("/todolist/users/{user}")
    public ResponseEntity<TodoList> getTodoList(@PathVariable String user) {
        return new ResponseEntity<>(todoService.getTodoListByUser(user), HttpStatus.OK);
    }
}
