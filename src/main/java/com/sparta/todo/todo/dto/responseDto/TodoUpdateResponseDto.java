package com.sparta.todo.todo.dto.responseDto;

import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {
    private final Long id;
    private final String userName;
    private final String todoTitle;
    private final String todoContents;

    public TodoUpdateResponseDto(Long id, String userName, String todoTitle, String todoContents) {
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
