package com.example.todolist.repository;

import com.example.todolist.domain.todo.TodoList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<TodoList, String> {
    List<TodoList> findTodoListByUser(String user);
    Optional<TodoList> findTodoListByUserAndIdx(String user, String idx);
}
