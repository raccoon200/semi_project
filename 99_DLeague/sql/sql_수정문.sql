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