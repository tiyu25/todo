package com.sparta.todo.comment.service;

import com.sparta.todo.comment.dto.CommentSaveRequestDto;
import com.sparta.todo.comment.dto.CommentSaveResponseDto;
import com.sparta.todo.comment.dto.CommentSimpleResponseDto;
import com.sparta.todo.comment.entity.Comment;
import com.sparta.todo.comment.repository.CommentRepository;
import com.sparta.todo.todo.entity.Todo;
import com.sparta.todo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    //댓글 등록
    @Transactional
    public CommentSaveResponseDto saveComment(Long todoId, CommentSaveRequestDto requestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 일정이 존재하지 않습니다."));

        Comment newComment = new Comment(requestDto.getUserName(), requestDto.getCommentContents(), todo);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getUserName(), savedComment.getCommentContents());
    }

    //댓글 전체 조회
    public List<CommentSimpleResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();
        for(Comment comment : commentList) {
            dtoList.add(new CommentSimpleResponseDto(comment.getId(), comment.getUserName(), comment.getCommentContents()));
        }

        return dtoList;
    }

    //댓글 단건 조회
    public CommentSimpleResponseDto getComment(Long todoId, Long commentId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 일정이 존재하지 않습니다."));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("해당 댓글이 존재하지 않습니다."));

        return new CommentSimpleResponseDto(comment.getId(), comment.getUserName(), comment.getCommentContents());
    }
}
