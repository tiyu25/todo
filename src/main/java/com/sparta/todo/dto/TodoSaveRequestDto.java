package com.sparta.todo.dto;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {
    private String userName;
    private String todoTitle;
    private String todoContents;
}
