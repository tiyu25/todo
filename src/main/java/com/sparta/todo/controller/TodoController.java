package com.sparta.todo.controller;

import com.sparta.todo.dto.TodoSaveRequestDto;
import com.sparta.todo.dto.TodoSaveResponseDto;
import com.sparta.todo.dto.TodoSimpleResponseDto;
import com.sparta.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    //일정 등록
    @PostMapping
    public ResponseEntity<TodoSaveResponseDto> saveTodo(@RequestBody TodoSaveRequestDto requestDto) {
        return ResponseEntity.ok(todoService.saveTodo(requestDto));
    }

    //일정 전체 조회
    @GetMapping
    public List<TodoSimpleResponseDto> getTodos() {
        return todoService.getTodos();
    }

    //일정 단건 조회
    @GetMapping("/param")
    public ResponseEntity<TodoSimpleResponseDto> getTodo(@RequestParam Long todoId) {
        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

}
