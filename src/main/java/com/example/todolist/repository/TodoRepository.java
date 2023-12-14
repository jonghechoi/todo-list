package com.example.todolist.repository;

import com.example.todolist.domain.todo.TodoList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<TodoList, String> {
    TodoList findTodoListByUser(String user);
}
