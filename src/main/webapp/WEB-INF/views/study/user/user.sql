show tables;

create table user (
	idx int not null auto_increment, /* 고유번호 */
	mid varchar(30) not null,  /* 아이디 */
	pwd varchar(30) not null, /* 비밀번호 */
	name varchar(30) not null, /* 성명 */
	age int default 20, /* 나이 */
	gender varchar(2) default '여자', /* 성별 */
	address varchar(10),  /* 주소 */
	primary key (idx),
	unique key (mid)
);

desc user;

-- user 다음에 user(_,_,_) 이런식으로 입력 필요한 필드 몇개만 지정할 수 있다. 
-- 그러면 당연히 이렇게 values(_,_,_) 에도 앞에서 지정된 필드 개수만큼들만 넣어야한다.
insert into user values (default, 'admin', '1234', '관리자', default, default, '서울');











