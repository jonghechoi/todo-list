package com.example.todolist.controller.todo;

import com.example.todolist.domain.todo.TodoList;
import com.example.todolist.service.todo.TodoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todolists")
public class TodoRestController {
    private final TodoServiceImpl todoService;

    public TodoRestController(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }

    /**
     *  Create Todo
     */
    @PostMapping("/todolist/{user}")
    public ResponseEntity<Boolean> create(@PathVariable String user,
                                          @RequestBody TodoList todoList) {
        if(todoService.setTodoList(todoList))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    /**
     *  Read Todo
     */
    @GetMapping("/todolist/users/{user}")
    public ResponseEntity<List<TodoList>> read(@PathVariable String user) {
        List<TodoList> todoList = todoService.getTodoListByUser(user);
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    /**
     *  Update Todo
     */
    @PutMapping("/todolist/users")
    public ResponseEntity<Boolean> update(@RequestBody TodoList todoList) throws Exception {
        if(todoService.updateTodoListBy(todoList))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }


    /**
     *  Delete Todo
     */
    @DeleteMapping("/todolist/users/{user}/{idx}")
    public ResponseEntity<Boolean> delete(@PathVariable String user,
                                          @PathVariable String idx) throws Exception {
        if(todoService.deleteTodoListByUserAndIdx(user, idx))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
