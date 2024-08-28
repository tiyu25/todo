package com.sparta.todo.comment.dto;

import lombok.Getter;

@Getter
public class CommentSaveRequestDto {
    private String userName;
    private String commentContents;
}
