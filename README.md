# API 명세서
## 일정 API
| 기능      | Method    | URL         | request   | response |
|---------| --------- |-------------| --------- |----------|
| 일정 등록   | POST      | /todo       | 요청 body  | 등록 정보    |
| 일정 조회   | GET       | /todo       |  | 단건 응답 정보 |
| 일정 목록 조회 | GET       | /todo/param |  | 다건 응답 정보 |
| 일정 수정   | PUT       | /todo/param | 요청 body  | 수정 정보    |
| 일정 삭제   | DELETE    | /todo/param |  | -        |

## 댓글 API
| 기능      | Method    | URL                               | request   | response |
|---------| --------- |-----------------------------------| --------- |----------|
| 댓글 등록   | POST      | /todo/comment                     | 요청 body  | 등록 정보    |
| 댓글 조회   | GET       | /todo/comments                    |  | 단건 응답 정보 |
| 댓글 목록 조회 | GET       | /todo/comment           |  | 다건 응답 정보 |
| 댓글 수정   | PUT       | /todo/comment | 요청 body  | 수정 정보    |
| 댓글 삭제   | DELETE    | /todo/comment |  | -        |

# ERD 작성하기
<img width="502" alt="KakaoTalk_Photo_2024-08-28-23-36-26" src="https://github.com/user-attachments/assets/72fc3f45-becc-451b-ab26-c85b67cf044c">