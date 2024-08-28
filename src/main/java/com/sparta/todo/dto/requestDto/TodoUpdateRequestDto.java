package com.sparta.todo.dto.requestDto;

import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {
    private String userName;
    private String todoTitle;
    private String todoContents;
}
