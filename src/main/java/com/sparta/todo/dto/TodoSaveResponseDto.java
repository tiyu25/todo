package com.sparta.todo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {
    private final Long id;
    private final String userName;
    private final String todoTitle;
    private final String todoContents;

    public TodoSaveResponseDto(Long id, String userName, String todoTitle, String todoContents) {
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
