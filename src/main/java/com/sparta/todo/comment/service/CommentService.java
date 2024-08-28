package com.sparta.todo.comment.service;

import com.sparta.todo.comment.dto.*;
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
            dtoList.add(new CommentSimpleResponseDto(
                                comment.getId(),
                                comment.getUserName(),
                                comment.getCommentContents(),
                                comment.getCreatedDate(),
                                comment.getUpdatedDate()
                            )
                        );
        }

        return dtoList;
    }

    //댓글 단건 조회
    public CommentSimpleResponseDto getComment(Long todoId, Long commentId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 일정이 존재하지 않습니다."));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("해당 댓글이 존재하지 않습니다."));

        return new CommentSimpleResponseDto(
                comment.getId(),
                comment.getUserName(),
                comment.getCommentContents(),
                comment.getCreatedDate(),
                comment.getCreatedDate()
        );
    }

    //댓글 수정
    @Transactional
    public CommentUpdateResponseDto updateComment(Long todoId, Long commentId, CommentUpdateRequestDto requestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 일정이 존재하지 않습니다."));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("해당 댓글이 존재하지 않습니다."));

        comment.update(requestDto.getUserName(), requestDto.getCommentContents());

        return new CommentUpdateResponseDto(comment.getId(), comment.getUserName(), comment.getCommentContents());
    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long todoId, Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new NullPointerException("해당 댓글이 없습니다.");
        }
        if (!commentRepository.existsById(todoId)) {
            throw new NullPointerException("해당 일정이 없습니다.");
        }

        commentRepository.deleteById(commentId);
    }

}
