package com.sparta.todo.todo.service;

import com.sparta.todo.todo.dto.requestDto.TodoSaveRequestDto;
import com.sparta.todo.todo.dto.requestDto.TodoUpdateRequestDto;
import com.sparta.todo.todo.dto.responseDto.TodoSaveResponseDto;
import com.sparta.todo.todo.dto.responseDto.TodoSimpleResponseDto;
import com.sparta.todo.todo.dto.responseDto.TodoUpdateResponseDto;
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

    //일정 단건 조회
    public TodoSimpleResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 일정이 존재하지 않습니다."));

        return new TodoSimpleResponseDto(todo);
    }

    //일정 수정
    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto requestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 일정이 존재하지 않습니다."));

        todo.update(requestDto.getUserName(), requestDto.getTodoTitle(), requestDto.getTodoContents());
        return new TodoUpdateResponseDto(todo.getId(), todo.getUserName(), todo.getTodoTitle(), todo.getTodoContents());
    }

    //일정 삭제
    @Transactional
    public void deleteTodo(Long todoId) {
        if (!todoRepository.existsById(todoId)) {
            throw new NullPointerException("해당 일정이 없습니다.");
        }

        todoRepository.deleteById(todoId);
    }
}
