/*기존 picked 제거*/
Drop table picked;

/*아래 picked 테이블 추가*/
CREATE TABLE picked(
board_num int,
FOREIGN KEY(board_num) REFERENCES board(board_num),
picked_user_id varchar(20)
);