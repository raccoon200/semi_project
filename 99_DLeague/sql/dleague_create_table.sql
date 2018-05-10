/* ȸ�� */
CREATE TABLE TBL_USER (
	USERID VARCHAR2(15) NOT NULL, /* �������̵� */
	PASSWORD VARCHAR2(200) NOT NULL, /* ��й�ȣ */
	USERNAME NVARCHAR2(5) NOT NULL, /* �����̸� */
	REGIONCODE VARCHAR2(6) NOT NULL, /* ���� */
	PHONE NVARCHAR2(11) NOT NULL, /* ��ȭ��ȣ */
	EMAIL VARCHAR2(50), /* �̸��� */
	BIRTHDAY DATE NOT NULL, /* ������� */
	TEAMNAME NVARCHAR2(15), /* ���̸� */
	PROFILE VARCHAR2(4000), /* ������ */
	GRADE NVARCHAR2(5) NOT NULL, /* ��� */
	PHOTO VARCHAR2(300), /* ���� */
	ENROLLDATE DATE DEFAULT SYSDATE NOT NULL /* ���Գ�¥ */
);
alter table tbl_user modify photo default 'default.jpg';
alter table tbl_user modify grade default '선수';

CREATE UNIQUE INDEX PK_TBL_USER
	ON TBL_USER (
		USERID ASC
	);

ALTER TABLE TBL_USER
	ADD
		CONSTRAINT PK_TBL_USER
		PRIMARY KEY (
			USERID
		);

/* �� ���� */
CREATE TABLE TEAM (
	TEAMNAME NVARCHAR2(15) NOT NULL, /* ���̸� */
	REGIONCODE VARCHAR2(6) NOT NULL, /* �����ڵ� */
	CAPTAIN VARCHAR2(15) NOT NULL, /* ���� */
	TEAMLOGO VARCHAR2(300), /* �� �ΰ� */
	INTRODUCE CLOB NOT NULL, /* �� �Ұ� */
	FOUNDINGDATE DATE NOT NULL, /* â���� */
	STATUS VARCHAR2(1) DEFAULT 'Y' NOT NULL /* STATUS */
);
alter table team modify teamlogo default 'default.jpg';
CREATE UNIQUE INDEX PK_TEAM
	ON TEAM (
		TEAMNAME ASC
	);

ALTER TABLE TEAM
	ADD
		CONSTRAINT PK_TEAM
		PRIMARY KEY (
			TEAMNAME
		);

/* ���� */
CREATE TABLE ACTIVITY (
	ACTIVITY_NO NUMBER NOT NULL, /* ������ȣ */
	HOME NVARCHAR2(15) NOT NULL, /* Ȩ�� */
	AWAY NVARCHAR2(15) NOT NULL, /* ������� */
	PLACE VARCHAR2(200) NOT NULL, /* ������ */
	ACTIVITYDATE DATE NOT NULL, /* ��⳯¥ */
	RESULT NVARCHAR2(15) NOT NULL /* ����� */
);

CREATE UNIQUE INDEX PK_ACTIVITY
	ON ACTIVITY (
		ACTIVITY_NO ASC
	);

ALTER TABLE ACTIVITY
	ADD
		CONSTRAINT PK_ACTIVITY
		PRIMARY KEY (
			ACTIVITY_NO
		);


/* ���� �Խ��� */
CREATE TABLE BOARD_REGION (
	BOARD_REGION_NO NUMBER NOT NULL, /* �����Խ��ǹ�ȣ */
	BOARD_REGION_TITLE VARCHAR2(50) NOT NULL, /* �����Խ������� */
	BOARD_REGION_WRITER VARCHAR2(15) NOT NULL, /* �������̵� */
	BOARD_REGIONCODE VARCHAR2(6) NOT NULL, /* �����ڵ� */
	BOARD_REGION_CONTENT CLOB NOT NULL, /* �����Խ��ǳ��� */
	BOARD_REGION_DATE DATE NOT NULL, /* �����Խó�¥ */
	ORIGINAL_FILE_NAME VARCHAR2(300), /* ���������̸� */
	RENAMED_FILE_NAME VARCHAR2(300), /* �ٲ������̸� */
	STATUS VARCHAR2(1) NOT NULL, /* ��뿩�� */
	COUNT NUMBER DEFAULT 0 NOT NULL /* ��ȸ�� */
);

CREATE UNIQUE INDEX PK_BOARD_REGION
	ON BOARD_REGION (
		BOARD_REGION_NO ASC
	);

ALTER TABLE BOARD_REGION
	ADD
		CONSTRAINT PK_BOARD_REGION
		PRIMARY KEY (
			BOARD_REGION_NO
		);

/* ���� ���� */
CREATE TABLE REGION (
	REGIONCODE VARCHAR2(6) NOT NULL, /* �����ڵ� */
	REGIONNAME NVARCHAR2(2) NOT NULL /* �����̸� */
);
insert into region values ('G1', '서울');
insert into region values ('G2', '경기');
insert into region values ('G3', '강원');
insert into region values ('G4', '충북');
insert into region values ('G5', '충남');
insert into region values ('G6', '경북');
insert into region values ('G7', '전북');
insert into region values ('G8', '전남');
insert into region values ('G9', '제주');

CREATE UNIQUE INDEX PK_REGION
	ON REGION (
		REGIONCODE ASC
	);

ALTER TABLE REGION
	ADD
		CONSTRAINT PK_REGION
		PRIMARY KEY (
			REGIONCODE
		);

/* ��� ���� */
CREATE TABLE GAME (
	GAME_NO NUMBER NOT NULL, /* ���� ��ȣ */
	HOME NVARCHAR2(15) NOT NULL, /* Ȩ���̸� */
	AWAY NVARCHAR2(15), /* ���̸� */
	GAMEDATE DATE NOT NULL, /* ���ӳ�¥ */
	GAME_REG_DATE DATE NOT NULL, /* �ۼ��� */
	PLACE VARCHAR2(200) NOT NULL, /* ������� */
	START_TIME VARCHAR2(20) NOT NULL, /* ���ӽ��۽ð� */
	GAME_CONTENT CLOB, /* ���ӳ��� */
	STATUS VARCHAR2(1) /* ���翩�� */
);
alter table game modify game_reg_date default sysdate;
CREATE UNIQUE INDEX PK_GAME
	ON GAME (
		GAME_NO ASC
	);

ALTER TABLE GAME
	ADD
		CONSTRAINT PK_GAME
		PRIMARY KEY (
			GAME_NO
		);

/* ��� ��û ��� �� ��� */
CREATE TABLE WAITTEAM (
	WAIT_NO NUMBER NOT NULL, /* ��� �� ��� ��ȣ */
	TEAMNAME NVARCHAR2(15) NOT NULL, /* �� �̸� */
	GAME_NO NUMBER NOT NULL, /* ���ӹ�ȣ */
	STATUS VARCHAR2(1) /* ���ο��� */
);

CREATE UNIQUE INDEX PK_WAITTEAM
	ON MY_SCHEMA.WAITTEAM (
		WAIT_NO ASC
	);

ALTER TABLE WAITTEAM
	ADD
		CONSTRAINT PK_WAITTEAM
		PRIMARY KEY (
			WAIT_NO
		);

/* �� ���� ������ */
CREATE TABLE MEMBER_REGISTER (
	MEMBER_REGISTER_NO NUMBER NOT NULL, /* �� ���� ���� ��ȣ */
	USERID VARCHAR2(15) NOT NULL, /* �������̵� */
	TEAMNAME NVARCHAR2(15) NOT NULL, /* �� �̸� */
	MESSAGE VARCHAR2(4000) NOT NULL, /* �޼��� */
	REGISTER_DATE DATE NOT NULL, /* ��û��¥ */
	YN VARCHAR2(1) /* ���ο��� */
);

CREATE UNIQUE INDEX PK_MEMBER_REGISTER
	ON MEMBER_REGISTER (
		MEMBER_REGISTER_NO ASC
	);

ALTER TABLE MEMBER_REGISTER
	ADD
		CONSTRAINT PK_MEMBER_REGISTER
		PRIMARY KEY (
			MEMBER_REGISTER_NO
		);

/* �� ��� ��� */
CREATE TABLE TEAM_MEMBER (
	USERID VARCHAR2(15) NOT NULL, /* �������̵� */
	TEAMNAME NVARCHAR2(15) NOT NULL, /* ���̸� */
	T_ENROLLDATE DATE NOT NULL, /* �Դ��� */
	CLASS VARCHAR2(10) NOT NULL /* ��� */
);

CREATE UNIQUE INDEX PK_TEAM_MEMBER
	ON MY_SCHEMA.TEAM_MEMBER (
		USERID ASC
	);

ALTER TABLE TEAM_MEMBER
	ADD
		CONSTRAINT PK_TEAM_MEMBER
		PRIMARY KEY (
			USERID
		);

/* �Ű� �Խ��� */
CREATE TABLE COMPLAIN (
	COMPLAIN_NO NUMBER NOT NULL, /* �Ű� ��ȣ */
	COMPLAIN_TITLE VARCHAR2(100) NOT NULL, /* �Ű� ���� */
	COMPLAIN_WRITER VARCHAR2(15) NOT NULL, /* �Ű��� */
	COMPLAIN_DATE DATE NOT NULL, /* �Ű� ��¥ */
	COMPLAIN_CONTENT CLOB NOT NULL, /* �Ű� ���� */
	C_USERID VARCHAR2(15), /* ������ */
	C_TEAMNAME NVARCHAR2(15), /* ������ */
	COMPLAIN_TYPE VARCHAR2(10) NOT NULL, /* �Ű����� */
	RESULT VARCHAR2(10) /* ó����� */
);

CREATE UNIQUE INDEX PK_COMPLAIN
	ON MY_SCHEMA.COMPLAIN (
		COMPLAIN_NO ASC
	);

ALTER TABLE COMPLAIN
	ADD
		CONSTRAINT PK_COMPLAIN
		PRIMARY KEY (
			COMPLAIN_NO
		);

/* �� ���� ���� ���� */
CREATE TABLE TEAM_REGISTER (
	TEAM_REGISTER_NO NUMBER NOT NULL, /* �� ��û�� ��ȣ */
	TEAMNAME NVARCHAR2(15) NOT NULL, /* ���̸� */
	T_REGISTER_WRITER VARCHAR2(15) NOT NULL, /* �� ��û�� */
	REGIONCODE VARCHAR2(6) NOT NULL, /* �����ڵ� */
	TEAMLOGO VARCHAR2(300), /* �� �ΰ� */
	INTRODUCE CLOB, /* �� �Ұ� */
	REGISTER_MSG VARCHAR2(4000), /* ��û�޼��� */
	REGISTER_DATE DATE NOT NULL, /* ��û�� */
	STATUS VARCHAR2(1) /* ���ο��� */
);

CREATE UNIQUE INDEX PK_TEAM_REGISTER
	ON MY_SCHEMA.TEAM_REGISTER (
		TEAM_REGISTER_NO ASC
	);

ALTER TABLE TEAM_REGISTER
	ADD
		CONSTRAINT PK_TEAM_REGISTER
		PRIMARY KEY (
			TEAM_REGISTER_NO
		);

/* Ż�� ȸ�� ���� */
CREATE TABLE TBL_DELETE_USER (
	DELETE_NO NUMBER NOT NULL, /* Ż��ȸ����ȣ */
	USERID VARCHAR2(15) NOT NULL, /* �������̵� */
	PASSWORD VARCHAR2(200) NOT NULL, /* �н����� */
	USERNAME NVARCHAR2(5) NOT NULL, /* ������ */
	REGIONCODE VARCHAR2(6) NOT NULL, /* �����ڵ� */
	PHONE NVARCHAR2(11) NOT NULL, /* ��ȭ��ȣ */
	PROFILE VARCHAR2(4000), /* ������ */
	PHOTO VARCHAR2(300), /* ���� */
	DELETEDATE DATE NOT NULL /* Ż���� */
);

CREATE UNIQUE INDEX PK_TBL_DELETE_USER
	ON MY_SCHEMA.TBL_DELETE_USER (
		DELETE_NO ASC
	);

ALTER TABLE TBL_DELETE_USER
	ADD
		CONSTRAINT PK_TBL_DELETE_USER
		PRIMARY KEY (
			DELETE_NO
		);

/* ���� �Խ��� */
CREATE TABLE BOARD_FREE (
	BOARD_FREE_NO NUMBER NOT NULL, /* �����Խ��� ��ȣ */
	BOARD_FREE_TITLE VARCHAR2(50) NOT NULL, /* �����Խ��� ���� */
	BOARD_FREE_WRITER VARCHAR2(15) NOT NULL, /* �����Խ��� �ۼ��� */
	BOARD_FREE_CONTENT CLOB NOT NULL, /* �����Խ��� ���� */
	BOARD_FREE_DATE DATE NOT NULL, /* �Խó�¥ */
	ORIGINAL_FILE_NAME VARCHAR2(300), /* ���������̸� */
	RENAMED_FILE_NAME VARCHAR2(300), /* �ٲ������̸� */
	STATUS VARCHAR2(1) NOT NULL, /* ��뿩�� */
	COUNT NUMBER NOT NULL /* ��ȸ�� */
);

CREATE UNIQUE INDEX PK_BOARD_FREE
	ON BOARD_FREE (
		BOARD_FREE_NO ASC
	);

ALTER TABLE BOARD_FREE
	ADD
		CONSTRAINT PK_BOARD_FREE
		PRIMARY KEY (
			BOARD_FREE_NO
		);

/* ���� �Խ��� ��� */
CREATE TABLE BOARD_FREE_COMMENT (
	BOARD_FREE_COMMENT_NO NUMBER NOT NULL, /* �����Խ��Ǵ�۹�ȣ */
	BOARD_FREE_COMMENT_LEVEL NUMBER NOT NULL, /* ���/���� */
	BOARD_FREE_COMMENT_WRITER VARCHAR2(15) NOT NULL, /* �ۼ��� */
	BOARD_FREE_COMMENT_CONTENT VARCHAR2(2000) NOT NULL, /* ���� */
	BOARD_FREE_REF NUMBER, /* �θ� �Խñ� ��ȣ */
	BOARD_FREE_COMMENT_REF NUMBER, /* �θ� ���� ��ȣ */
	BOARD_FREE_COMMENT_DATE DATE NOT NULL /* �ۼ��� */
);

CREATE UNIQUE INDEX PK_BOARD_FREE_COMMENT
	ON MY_SCHEMA.BOARD_FREE_COMMENT (
		BOARD_FREE_COMMENT_NO ASC
	);

ALTER TABLE BOARD_FREE_COMMENT
	ADD
		CONSTRAINT PK_BOARD_FREE_COMMENT
		PRIMARY KEY (
			BOARD_FREE_COMMENT_NO
		);

/* �����Խ��Ǵ�� */
CREATE TABLE BOARD_REGION_COMMENT (
	BOARD_REGION_COMMENT_NO NUMBER NOT NULL, /* �����Խ��Ǵ�۹�ȣ */
	BOARD_REGION_COMMENT_LEVEL NUMBER NOT NULL, /* ���/���� */
	BOARD_REGION_COMMENT_WRITER VARCHAR2(15) NOT NULL, /* �ۼ��� */
	BOARD_REGION_COMMENT_CONTENT VARCHAR2(2000) NOT NULL, /* ���� */
	BOARD_REGION_REF NUMBER, /* �θ� �Խñ� ��ȣ */
	BOARD_REGION_COMMENT_REF NUMBER, /* �θ� ���� ��ȣ */
	BOARD_REGION_COMMENT_DATE DATE NOT NULL /* �ۼ��� */
);

CREATE UNIQUE INDEX PK_BOARD_REGION_COMMENT
	ON BOARD_REGION_COMMENT (
		BOARD_REGION_COMMENT_NO ASC
	);

ALTER TABLE BOARD_REGION_COMMENT
	ADD
		CONSTRAINT PK_BOARD_REGION_COMMENT
		PRIMARY KEY (
			BOARD_REGION_COMMENT_NO
		);

/* ���� �Խ��� */
CREATE TABLE NOTICE (
	NOTICE_NO NUMBER NOT NULL, /* ������ȣ */
	NOTICE_TITLE VARCHAR2(100) NOT NULL, /* �������� */
	NOTICE_WRITER VARCHAR2(15) NOT NULL, /* �ۼ��� */
	NOTICE_CONTENT VARCHAR2(4000) NOT NULL, /* ������ */
	NOTICE_DATE DATE NOT NULL, /* ������ */
	ORIGINAL_FILE_NAME VARCHAR2(300), /* ���������̸� */
	RENAMED_FILE_NAME VARCHAR2(300), /* �ٲ������̸� */
	STATUS CHAR(1) NOT NULL /* ��뿩�� */
);

CREATE UNIQUE INDEX PK_NOTICE
	ON NOTICE (
		NOTICE_NO ASC
	);

ALTER TABLE NOTICE
	ADD
		CONSTRAINT PK_NOTICE
		PRIMARY KEY (
			NOTICE_NO
		);

ALTER TABLE TBL_USER
	ADD
		CONSTRAINT FK_TEAM_TO_TBL_USER
		FOREIGN KEY (
			TEAMNAME
		)
		REFERENCES TEAM (
			TEAMNAME
		);

ALTER TABLE TBL_USER
	ADD
		CONSTRAINT FK_REGION_TO_TBL_USER
		FOREIGN KEY (
			REGIONCODE
		)
		REFERENCES REGION (
			REGIONCODE
		);

ALTER TABLE TEAM
	ADD
		CONSTRAINT FK_REGION_TO_TEAM
		FOREIGN KEY (
			REGIONCODE
		)
		REFERENCES REGION (
			REGIONCODE
		);

ALTER TABLE TEAM
	ADD
		CONSTRAINT FK_TBL_USER_TO_TEAM
		FOREIGN KEY (
			CAPTAIN
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE ACTIVITY
	ADD
		CONSTRAINT FK_TEAM_TO_ACTIVITY
		FOREIGN KEY (
			HOME
		)
		REFERENCES TEAM (
			TEAMNAME
		);

ALTER TABLE ACTIVITY
	ADD
		CONSTRAINT FK_TEAM_TO_ACTIVITY2
		FOREIGN KEY (
			AWAY
		)
		REFERENCES TEAM (
			TEAMNAME
		);

ALTER TABLE BOARD_REGION
	ADD
		CONSTRAINT FK_TBL_USER_TO_BOARD_REGION
		FOREIGN KEY (
			BOARD_REGION_WRITER
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE BOARD_REGION
	ADD
		CONSTRAINT FK_REGION_TO_BOARD_REGION
		FOREIGN KEY (
			BOARD_REGIONCODE
		)
		REFERENCES REGION (
			REGIONCODE
		);

ALTER TABLE GAME
	ADD
		CONSTRAINT FK_TEAM_TO_GAME
		FOREIGN KEY (
			HOME
		)
		REFERENCES TEAM (
			TEAMNAME
		);

ALTER TABLE GAME
	ADD
		CONSTRAINT FK_TEAM_TO_GAME2
		FOREIGN KEY (
			AWAY
		)
		REFERENCES TEAM (
			TEAMNAME
		);

ALTER TABLE WAITTEAM
	ADD
		CONSTRAINT FK_TEAM_TO_WAITTEAM
		FOREIGN KEY (
			TEAMNAME
		)
		REFERENCES TEAM (
			TEAMNAME
		);

ALTER TABLE WAITTEAM
	ADD
		CONSTRAINT FK_GAME_TO_WAITTEAM
		FOREIGN KEY (
			GAME_NO
		)
		REFERENCES GAME (
			GAME_NO
		);

ALTER TABLE MEMBER_REGISTER
	ADD
		CONSTRAINT FK_TBL_USER_TO_MEMBER_REGISTER
		FOREIGN KEY (
			USERID
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE MEMBER_REGISTER
	ADD
		CONSTRAINT FK_TEAM_TO_MEMBER_REGISTER
		FOREIGN KEY (
			TEAMNAME
		)
		REFERENCES TEAM (
			TEAMNAME
		);

ALTER TABLE TEAM_MEMBER
	ADD
		CONSTRAINT FK_TEAM_TO_TEAM_MEMBER
		FOREIGN KEY (
			TEAMNAME
		)
		REFERENCES TEAM (
			TEAMNAME
		);

ALTER TABLE TEAM_MEMBER
	ADD
		CONSTRAINT FK_TBL_USER_TO_TEAM_MEMBER
		FOREIGN KEY (
			USERID
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE COMPLAIN
	ADD
		CONSTRAINT FK_TBL_USER_TO_COMPLAIN
		FOREIGN KEY (
			C_USERID
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE COMPLAIN
	ADD
		CONSTRAINT FK_TBL_USER_TO_COMPLAIN2
		FOREIGN KEY (
			COMPLAIN_WRITER
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE COMPLAIN
	ADD
		CONSTRAINT FK_TEAM_TO_COMPLAIN
		FOREIGN KEY (
			C_TEAMNAME
		)
		REFERENCES TEAM (
			TEAMNAME
		);

ALTER TABLE TEAM_REGISTER
	ADD
		CONSTRAINT FK_TBL_USER_TO_TEAM_REGISTER
		FOREIGN KEY (
			T_REGISTER_WRITER
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE TEAM_REGISTER
	ADD
		CONSTRAINT FK_REGION_TO_TEAM_REGISTER
		FOREIGN KEY (
			REGIONCODE
		)
		REFERENCES REGION (
			REGIONCODE
		);

ALTER TABLE TBL_DELETE_USER
	ADD
		CONSTRAINT FK_REGION_TO_TBL_DELETE_USER
		FOREIGN KEY (
			REGIONCODE
		)
		REFERENCES REGION (
			REGIONCODE
		);

ALTER TABLE BOARD_FREE
	ADD
		CONSTRAINT FK_TBL_USER_TO_BOARD_FREE
		FOREIGN KEY (
			BOARD_FREE_WRITER
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE BOARD_FREE_COMMENT
	ADD
		CONSTRAINT FK_BOARD_FREE_TO_FREE_COMMENT
		FOREIGN KEY (
			BOARD_FREE_REF
		)
		REFERENCES BOARD_FREE (
			BOARD_FREE_NO
		);

ALTER TABLE BOARD_FREE_COMMENT
	ADD
		CONSTRAINT FK_TBL_USER_TO_FREE_COMMENT
		FOREIGN KEY (
			BOARD_FREE_COMMENT_WRITER
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE BOARD_FREE_COMMENT
	ADD
		CONSTRAINT FK_FREE_COMMENT_TO_COMMENT
		FOREIGN KEY (
			BOARD_FREE_COMMENT_REF
		)
		REFERENCES BOARD_FREE_COMMENT (
			BOARD_FREE_COMMENT_NO
		);

ALTER TABLE BOARD_REGION_COMMENT
	ADD
		CONSTRAINT FK_BOARD_TO_COMMENT
		FOREIGN KEY (
			BOARD_REGION_COMMENT_REF
		)
		REFERENCES BOARD_REGION_COMMENT (
			BOARD_REGION_COMMENT_NO
		);

ALTER TABLE BOARD_REGION_COMMENT
	ADD
		CONSTRAINT FK_BOARD_REGION_TO_COMMENT
		FOREIGN KEY (
			BOARD_REGION_REF
		)
		REFERENCES BOARD_REGION (
			BOARD_REGION_NO
		);

ALTER TABLE BOARD_REGION_COMMENT
	ADD
		CONSTRAINT FK_TBL_USER_TO_COMMENT
		FOREIGN KEY (
			BOARD_REGION_COMMENT_WRITER
		)
		REFERENCES TBL_USER (
			USERID
		);

ALTER TABLE NOTICE
	ADD
		CONSTRAINT FK_TBL_USER_TO_NOTICE
		FOREIGN KEY (
			NOTICE_WRITER
		)
		REFERENCES TBL_USER (
			USERID
		);
        
insert into tbl_user values('admin', '1234', 'admin', 'G2', '01027809071', 'raccoon200@naver.com', '930322', null, '관리자관리자', '관리자', default, sysdate);
COMMIT;

ALTER TABLE ACTIVITY
	ADD
		CONSTRAINT FK_GAME_TO_ACTIVITY
		FOREIGN KEY (
			ACTIVITY_NO
		)
		REFERENCES GAME (
			GAME_NO
		);