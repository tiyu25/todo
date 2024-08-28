package com.sparta.todo.todo.entity;

import com.sparta.todo.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "todo_title")
    private String todoTitle;

    @Column(name = "todo_contents")
    private String todoContents;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public Todo(String userName, String todoTitle, String todoContents) {
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }

    public void update(String userName, String todoTitle, String todoContents) {
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
