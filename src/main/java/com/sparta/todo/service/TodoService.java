package com.sparta.todo.service;

import com.sparta.todo.dto.TodoSaveRequestDto;
import com.sparta.todo.dto.TodoSaveResponseDto;
import com.sparta.todo.dto.TodoSimpleResponseDto;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository todoRepository;

    //일정 등록
    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto requestDto) {
        Todo newTodo = new Todo( requestDto.getUserName(), requestDto.getTodoTitle(), requestDto.getTodoContents() );
        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponseDto(savedTodo.getId(), savedTodo.getUserName(), savedTodo.getTodoTitle(), savedTodo.getTodoContents() );
    }

    //일정 전체 조회
    public List<TodoSimpleResponseDto> getTodos() {
        List<Todo> todos = todoRepository.findAll();

        List<TodoSimpleResponseDto> dtoList = new ArrayList<>();
        for (Todo todo : todos ) {
            TodoSimpleResponseDto dto = new TodoSimpleResponseDto(todo);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
