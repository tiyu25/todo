package com.sparta.todo.todo.dto.responseDto;

import com.sparta.todo.comment.dto.CommentSimpleResponseDto;
import com.sparta.todo.comment.entity.Comment;
import com.sparta.todo.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TodoSimpleResponseDto {
    private final Long id;
    private final String userName;
    private final String todoTitle;
    private final String todoContents;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;
    private final List<CommentSimpleResponseDto> comments;

    public TodoSimpleResponseDto(Long id, String userName, String todoTitle, String todoContents, LocalDateTime createdDate, LocalDateTime updatedDate, List<Comment> comments) {
        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : comments) {
            dtoList.add(new CommentSimpleResponseDto(comment.getId(), comment.getUserName(), comment.getCommentContents(), comment.getCreatedDate(), comment.getUpdatedDate()));
        }
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.comments = dtoList;
    }

    public TodoSimpleResponseDto(Todo todo) {
        this.id = todo.getId();
        this.userName = todo.getUserName();
        this.todoTitle = todo.getTodoTitle();
        this.todoContents = todo.getTodoContents();
        this.createdDate = todo.getCreatedDate();
        this.updatedDate = todo.getUpdatedDate();
        this.comments = new ArrayList<>();
    }
}
