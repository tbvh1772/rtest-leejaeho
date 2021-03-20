-- 유저 TABLE
CREATE TABLE USER_TEST(
	user_id varchar2(20) not null  PRIMARY KEY,
	user_passwd varchar2(20) not null,
	user_name varchar2(20) not null,
	user_date date default sysdate
)
drop table community_test

-- 커뮤니티 TABLE
CREATE TABLE COMMUNITY_TEST(
	post_no number(10,0),
	user_id varchar(20) not null,
	post_title varchar(50) not null,
	post_content varchar(500) not null,
	post_date date DEFAULT sysdate,
	post_updatedate date DEFAULT sysdate,
	file_name varchar(40)
)

--post_no 기본키 설정
alter table community_test add constraint pk_comunity primary key (post_no);

--post_no에 사용할 시퀀스 생성
create sequence seq_post;

--user_id 외래키 설정
alter table COMMUNITY_TEST add constraint uc_id foreign key(user_id) references USER_TEST(user_id) ON DELETE CASCADE

-- USER_TEST 테이블에 값 입력
insert into USER_TEST (user_id,user_passwd,user_name) values('lee1','lee1','이재호');
insert into USER_TEST (user_id,user_passwd,user_name) values('rtest','rtest','알서포트');

-- COMMUNITY_TEST 테이블이 값 입력
insert into COMMUNITY_TEST(post_no, post_title, post_content, user_id) values(seq_post.nextval,'제목 입력','내용 입력','lee1');
insert into COMMUNITY_TEST(post_no, post_title, post_content, user_id) values(seq_post.nextval,'제목을 입력 하세요','내용을 입력 하세요','rtest');
insert into COMMUNITY_TEST(post_no, post_title, post_content, user_id) (select seq_post.nextval,post_title,post_content,user_id from COMMUNITY_TEST); 

