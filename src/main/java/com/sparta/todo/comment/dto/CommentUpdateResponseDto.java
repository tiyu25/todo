package com.sparta.todo.comment.dto;

import lombok.Getter;

@Getter
public class CommentUpdateResponseDto {
    private final Long id;
    private final String userName;
    private final String commentContents;

    public CommentUpdateResponseDto(Long id, String userName, String commentContents) {
        this.id = id;
        this.userName = userName;
        this.commentContents = commentContents;
    }
}
