package com.sparta.todo.comment.controller;

import com.sparta.todo.comment.dto.CommentSaveRequestDto;
import com.sparta.todo.comment.dto.CommentSaveResponseDto;
import com.sparta.todo.comment.dto.CommentSimpleResponseDto;
import com.sparta.todo.comment.service.CommentService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 등록
    @PostMapping("/todo/comment")
    public CommentSaveResponseDto saveComment(@RequestParam Long todoId, @RequestBody CommentSaveRequestDto requestDto) {
        return commentService.saveComment(todoId, requestDto);
    }

    //댓글 전체 조회
    @GetMapping("/todo/comments")
    public List<CommentSimpleResponseDto> getComments() {
        return commentService.getComments();
    }

    //댓글 단건 조회
    @GetMapping("/todo/comment")
    public ResponseEntity<CommentSimpleResponseDto> getComment(@RequestParam Long todoId, @RequestParam Long commentId) {
        return ResponseEntity.ok(commentService.getComment(todoId, commentId));
    }

}
