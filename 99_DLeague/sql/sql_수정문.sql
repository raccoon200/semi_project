--05.10
alter table tbl_user drop COLUMN birthday;
alter table tbl_user add birthday varchar2(30);
update tbl_user set birthday = '930322';
alter table tbl_user modify birthday not null;
alter table tbl_user modify photo default 'default.jpg';
alter table tbl_user modify grade default '선수';
ALTER TABLE ACTIVITY
	ADD
		CONSTRAINT FK_GAME_TO_ACTIVITY
		FOREIGN KEY (
			ACTIVITY_NO
		)
		REFERENCES GAME (
			GAME_NO
		);
		
		
--05.11

--지역게시판
drop table board_region_comment;
drop table board_region;

CREATE TABLE BOARD_REGION (
	BOARD_REGION_NO NUMBER NOT NULL,
	BOARD_REGION_TITLE VARCHAR2(50) NOT NULL,
	BOARD_REGION_WRITER VARCHAR2(15) NOT NULL, 
	BOARD_REGIONCODE VARCHAR2(6) NOT NULL,
	BOARD_REGION_CONTENT CLOB NOT NULL,
	BOARD_REGION_DATE DATE NOT NULL,
	ORIGINAL_FILE_NAME VARCHAR2(300),
	RENAMED_FILE_NAME VARCHAR2(300),
	STATUS VARCHAR2(1) NOT NULL,
	COUNT NUMBER DEFAULT 0 NOT NULL
    
);

ALTER TABLE BOARD_REGION
	ADD
	CONSTRAINT PK_BOARD_REGION
	PRIMARY KEY (
		BOARD_REGION_NO
	);
	
CREATE TABLE BOARD_REGION_COMMENT (
	BOARD_REGION_COMMENT_NO NUMBER NOT NULL, /* �����Խ��Ǵ�۹�ȣ */
	BOARD_REGION_COMMENT_LEVEL NUMBER NOT NULL, /* ���/���� */
	BOARD_REGION_COMMENT_WRITER VARCHAR2(15) NOT NULL, /* �ۼ��� */
	BOARD_REGION_COMMENT_CONTENT VARCHAR2(2000) NOT NULL, /* ���� */
	BOARD_REGION_REF NUMBER, /* �θ� �Խñ� ��ȣ */
	BOARD_REGION_COMMENT_REF NUMBER, /* �θ� ���� ��ȣ */
	BOARD_REGION_COMMENT_DATE DATE NOT NULL /* �ۼ��� */,
    constraint pk_board_region_comment primary key(board_region_comment_no),
    constraint fk_board_region_ref foreign key(board_region_ref) references board_region(board_region_no) on delete cascade,
    constraint fk_board_region_comment_ref foreign key(board_region_comment_ref) references board_region_comment(board_region_comment_no) on delete cascade
);

--자유게시판
drop table board_free_comment;
drop table board_free;

CREATE TABLE BOARD_FREE (
	BOARD_FREE_NO NUMBER NOT NULL, /* �����Խ��� ��ȣ */
	BOARD_FREE_TITLE VARCHAR2(50) NOT NULL, /* �����Խ��� ���� */
	BOARD_FREE_WRITER VARCHAR2(15) NOT NULL, /* �����Խ��� �ۼ��� */
	BOARD_FREE_CONTENT CLOB NOT NULL, /* �����Խ��� ���� */
	BOARD_FREE_DATE DATE NOT NULL, /* �Խó�¥ */
	ORIGINAL_FILE_NAME VARCHAR2(300), /* ���������̸� */
	RENAMED_FILE_NAME VARCHAR2(300), /* �ٲ������̸� */
	STATUS VARCHAR2(1) NOT NULL, /* ��뿩�� */
	COUNT NUMBER NOT NULL, /* ��ȸ�� */
    constraint pk_board_free primary key(board_free_no)
);

CREATE TABLE BOARD_FREE_COMMENT (
	BOARD_FREE_COMMENT_NO NUMBER NOT NULL, /* �����Խ��Ǵ�۹�ȣ */
	BOARD_FREE_COMMENT_LEVEL NUMBER NOT NULL, /* ���/���� */
	BOARD_FREE_COMMENT_WRITER VARCHAR2(15) NOT NULL, /* �ۼ��� */
	BOARD_FREE_COMMENT_CONTENT VARCHAR2(2000) NOT NULL, /* ���� */
	BOARD_FREE_REF NUMBER, /* �θ� �Խñ� ��ȣ */
	BOARD_FREE_COMMENT_REF NUMBER, /* �θ� ���� ��ȣ */
	BOARD_FREE_COMMENT_DATE DATE NOT NULL, /* �ۼ��� */
    constraint pk_free_free_comment primary key(board_free_comment_no),
    constraint fk_free_free_ref foreign key(board_free_ref) references board_free(board_free_no) on delete cascade,
    constraint fk_free_free_comment_ref foreign key(board_free_comment_ref) references board_free_comment(board_free_comment_no) on delete cascade

);
