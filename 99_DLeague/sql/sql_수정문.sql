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