/*유저*/
insert into tbl_user values('deayeon', '1234', '대연킴', 'G1', '01027809071', 'raccoon200@naver.com', '930322', null, '투톱팀원', '팀장', default, sysdate);
insert into tbl_user values('test1', '1234', 'test', 'G1', '01027809071', 'raccoon200@naver.com', '930322', null, 'test1', '팀장', default, sysdate);
insert into tbl_user values('test2', '1234', 'test', 'G1', '01027809071', 'raccoon200@naver.com', '930322', null, 'test2', '팀장', default, sysdate);
insert into tbl_user values('test3', '1234', 'test', 'G1', '01027809071', 'raccoon200@naver.com', '930322', null, 'test3', '팀장', default, sysdate);
insert into tbl_user values('test4', '1234', 'test', 'G1', '01027809071', 'raccoon200@naver.com', '930322', null, 'test4', '팀장', default, sysdate);
insert into tbl_user values('test5', '1234', 'test', 'G1', '01027809071', 'raccoon200@naver.com', '930322', null, 'test5', '팀장', default, sysdate);
insert into tbl_user values('test6', '1234', 'test', 'G1', '01027809071', 'raccoon200@naver.com', '930322', null, 'test6', '팀장', default, sysdate);
insert into tbl_user values('test7', '1234', 'test7', 'G2', '01027809071', 'raccoon200@naver.com', '930322', null, 'test7', '팀원', default, sysdate);


/*팀*/
insert into team values('투톱체제','G1','deayeon',null,'연경이가 부팀장이에요!','2018/05/01','Y');
insert into team values('testTeam1','G1','test1',null,'testTeam1이에요!!!!!',sysdate,'Y');
insert into team values('testTeam2','G1','test2',null,'testTeam1이에요!!!!!',sysdate,'Y');
insert into team values('testTeam3','G1','test3',null,'testTeam1이에요!!!!!',sysdate,'Y');
insert into team values('testTeam4','G2','test4',null,'testTeam1이에요!!!!!',sysdate,'Y');
insert into team values('testTeam5','G2','test5',null,'testTeam1이에요!!!!!',sysdate,'Y');
insert into team values('testTeam6','G2','test6',null,'testTeam1이에요!!!!!',sysdate,'Y');
/*팀맴버*/
insert into team_member values('deayeon','투톱체제',sysdate,'팀장');
insert into team_member values('test1','testTeam1',sysdate,'팀장');
insert into team_member values('test2','testTeam2',sysdate,'팀장');
insert into team_member values('test3','testTeam3',sysdate,'팀장');
insert into team_member values('test4','testTeam4',sysdate,'팀장');
insert into team_member values('test5','testTeam5',sysdate,'팀장');
insert into team_member values('test6','testTeam6',sysdate,'팀장');
insert into team_member values('test7','testTeam5',sysdate,'팀원');

/*팀업데이트*/
update tbl_user set teamname='투톱체제';
update tbl_user set teamname='testTeam1' where userid='test1';
update tbl_user set teamname='testTeam2' where userid='test2';
update tbl_user set teamname='testTeam3' where userid='test3';
update tbl_user set teamname='testTeam4' where userid='test4';
update tbl_user set teamname='testTeam5' where userid='test5';
update tbl_user set teamname='testTeam6' where userid='test6';
update tbl_user set teamname='testTeam5' where userid='test7';