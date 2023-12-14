package com.example.todolist.service.todo;

import com.example.todolist.domain.todo.TodoList;

import java.util.Optional;

public interface TodoService {
    boolean createTodoList(TodoList todoList);
    TodoList getTodoListByUser(String user);
}
