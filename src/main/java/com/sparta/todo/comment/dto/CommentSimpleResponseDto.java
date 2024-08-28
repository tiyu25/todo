package com.sparta.todo.comment.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSimpleResponseDto {
    private final Long id;
    private final String userName;
    private final String commentContents;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;

    public CommentSimpleResponseDto(Long id, String userName, String commentContents, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.userName = userName;
        this.commentContents = commentContents;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
