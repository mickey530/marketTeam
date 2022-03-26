
/*foreign key 제거*/
/*제약조건 확인(혹은 밑에 드랍 걍 해보고 에러메시지에서 체크)*/
select * from information_schema.table_constraints where board;
/*확인한 거 아래 대입*/
alter table board drop foreign key [제약조건명];



*기존 picked 제거*/
Drop table picked;

/*아래 picked 테이블 추가*/
CREATE TABLE picked(
board_num int,
FOREIGN KEY(board_num) REFERENCES board(board_num),
picked_user_id varchar(20)
);
/*board에서 기존 board_picked_bum 칼럼 제거*/
ALTER TABLE board Drop column board_picked_num;
/*아래 새로운 칼럼 추가*/
ALTER TABLE board ADD board_picked_num int default 0;




