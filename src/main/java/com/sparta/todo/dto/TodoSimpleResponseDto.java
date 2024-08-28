package com.sparta.todo.dto;

import com.sparta.todo.entity.Todo;
import lombok.Getter;

@Getter
public class TodoSimpleResponseDto {
    private final Long id;
    private final String userName;
    private final String todoTitle;
    private final String todoContents;

    public TodoSimpleResponseDto(Long id, String userName, String todoTitle, String todoContents) {
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }

    public TodoSimpleResponseDto(Todo todo) {
        this.id = todo.getId();
        this.userName = todo.getUserName();
        this.todoTitle = todo.getTodoTitle();
        this.todoContents = todo.getTodoContents();
    }
}
