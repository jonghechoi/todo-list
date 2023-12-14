package com.example.todolist.service.todo;

import com.example.todolist.domain.todo.TodoList;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;

    @Override
    public boolean createTodoList(TodoList todoList) {
        Optional<TodoList> optionalTodo = Optional.of(todoRepository.save(todoList));
        // 나중에 exception 핸들링 필요
        // optionalTodo.orElseThrow();
        return !optionalTodo.isEmpty();
    }

    @Override
    public TodoList getTodoListByUser(String user) {
        return todoRepository.findTodoListByUser(user);
    };
}
