package com.sparta.todo.todo.dto.requestDto;

import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {
    private String userName;
    private String todoTitle;
    private String todoContents;
}
