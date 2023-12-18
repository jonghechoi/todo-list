package com.example.todolist.domain.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todocollection")
public class TodoList {
    @Id
    private String id;
    private String idx;
    private String user;
    private String title;
    private String contents;
    private String date;
    private String time;

    // Builder로 title, contents, date, time 중에 바뀌는게 있으면 그것들만 사용할 수 있도록!!!! -> update 용

    @Override
    public String toString() {
        return "user : " + getUser() + " contents : " + getContents();
    }
}
