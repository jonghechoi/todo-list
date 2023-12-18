package com.example.todolist.service.todo;

import com.example.todolist.domain.todo.TodoList;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ExpressionInvocationTargetException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;

    @Override
    public boolean setTodoList(TodoList todoList) {
        Optional<TodoList> optionalTodo = Optional.of(todoRepository.save(todoList));
        // 나중에 exception 핸들링 필요
        // optionalTodo.orElseThrow();
        return !optionalTodo.isEmpty();
    }

    @Override
    public List<TodoList> getTodoListByUser(String user) {
        return todoRepository.findTodoListByUser(user);
    };

    @Override
    public boolean deleteTodoListByUserAndIdx(String user, String idx) throws Exception {
        return todoRepository.findTodoListByUserAndIdx(user, idx)
                .map(todoList -> {
                    todoRepository.delete(todoList);
                    return true; })
                .orElseThrow(() -> new Exception("No such TodoList"));
    }

    @Override
    public boolean updateTodoListBy(TodoList todoList) {
        todoRepository.findTodoListByUserAndIdx(todoList.getUser(), todoList.getIdx())
                .map(newTodoList -> {
                    newTodoList.setTitle(newTodoList.getTitle());
                    newTodoList.setContents();
                    newTodoList.setDate();
                    newTodoList.setTime();
                    todoRepository.save()
                } )

    }
}
