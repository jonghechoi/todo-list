package com.example.todolist.domain.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todocollection")
public class TodoList {
    @Id
    private String id;
    private String user;
    private String contents;
}
