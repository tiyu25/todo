CREATE TABLE `schedule` (
    id	                bigint          not null    comment '일정 아이디' auto_increment primary key,
    user_name	        varchar(10)     not null    comment '작성자',
    schedule_title      varchar(100)    not null    comment '할일 제목',
    schedule_content    varchar(255)    not null    comment '할일 내용',
    created_date        datetime       not null    comment '작성일',
    updated_date        datetime       not null    comment '수정일'
);

CREATE TABLE `comment` (
   comment_id	                bigint          not null    comment '댓글 아이디' auto_increment primary key,
   todo_id	        bigint          not null    comment '할일 아이디',
   user_name	        varchar(10)          not null    comment '작성자',
   comment_contents    varchar(100)    not null    comment '댓글 내용',
   created_date        datetime       not null    comment '작성일',
   updated_date        datetime       not null    comment '수정일',
   foreign key(todo_id) references todo_id(id)
);