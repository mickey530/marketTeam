CREATE TABLE userinfo(
user_num int auto_increment primary key,
user_id varchar(20) not null unique,
user_pw varchar(20) not null,
user_name varchar(10) not null,
user_pnum varchar(15) not null,
user_address varchar(30) not null
);
CREATE TABLE board(
user_id varchar(20) not null,
board_info boolean not null,
board_num int auto_increment PRIMARY KEY,
board_content varchar(2000) not null,
board_category varchar(10) not null,
board_amount int not null,
board_sold boolean not null,
board_reported int not null,
board_writetime datetime default now(),
board_updatetime datetime default now(),
FOREIGN KEY(user_id) REFERENCES userinfo(user_id)
);
CREATE TABLE boardcomment(
comment_num int PRIMARY KEY auto_increment,
comment_time datetime default now(),
comment_id varchar(20) not null,
comment_board_num int not null,
comment_content varchar(100),
FOREIGN KEY(comment_id) REFERENCES userinfo(user_id),
FOREIGN KEY(comment_board_num) REFERENCES board(board_num)
);
CREATE TABLE picked(
picked_id varchar(20) not null,
picked_board_info boolean not null,
picked_board_num int not null,
picked_num int PRIMARY KEY,
FOREIGN KEY(picked_id) REFERENCES userinfo(user_id),
FOREIGN KEY(picked_board_num) REFERENCES board(board_num)
);
CREATE TABLE reportlist(
reporting_id varchar(20) not null,
reported_board_num int not null,
reported_reason varchar(100) not null,
FOREIGN KEY(reporting_id) REFERENCES userinfo(user_id),
FOREIGN KEY(reported_board_num) REFERENCES board(board_num)
);