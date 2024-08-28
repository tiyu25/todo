package com.sparta.todo.comment.dto;

import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {
    private String userName;
    private String commentContents;
}
