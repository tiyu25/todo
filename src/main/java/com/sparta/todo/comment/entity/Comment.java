package com.sparta.todo.comment.entity;

import com.sparta.todo.todo.entity.Timestamped;
import com.sparta.todo.todo.entity.Todo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "comment_contents")
    private String commentContents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment(String userName, String commentContents, Todo todo) {
        this.userName = userName;
        this.commentContents = commentContents;
        this.todo = todo;
    }

    public void update(String userName, String commentContents) {
        this.userName = userName;
        this.commentContents = commentContents;
    }
}
