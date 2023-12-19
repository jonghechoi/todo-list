package com.example.todolist.service.todo;

import com.example.todolist.domain.todo.TodoList;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    boolean setTodoList(TodoList todoList);
    List<TodoList> getTodoListByUser(String user);
    boolean deleteTodoListByUserAndIdx(String user, String idx) throws Exception;
    boolean updateTodoListBy(TodoList todoList) throws Exception;
}
