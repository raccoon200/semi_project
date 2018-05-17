<!-- 트리거 뭐있는지 검색 -->
select * from user_triggers;

<!-- tbl_user의 teamname가 null이 아니고 grade가 선수에서 팀원으로 바뀌었을때 바뀐 값으로 team_member에 추가하는 트리거 -->
create or replace trigger trg_add_team_member
after update of grade on tbl_user
for each row
when (old.grade='선수' and new.grade='팀원' and new.teamname is not null)
begin
insert into team_member values (:old.userid, :new.teamname, sysdate, :new.grade);
end;
/
<!-- 이런식으로 업데이트 -->
--update tbl_user set teamname='testTeam5', grade='팀원' where userid = 'test20';

<!-- tbl_user에서 grade를 바꿨을때 grade가 팀원이거나 팀장이고 teamname이 null이 아닐때 grade를 team_member에 수정하는 트리거 -->
create or replace trigger trg_update_grade
after update of grade on tbl_user
for each row
when (new.grade='팀원' or new.grade= '팀장' and new.teamname is not null)
begin
dbms_output.put_line('트리거 실행');
update team_member set grade = :new.grade where userid= :new.userid;
end;
/

<!-- team_member에서 grade를 팀장으로 바꾸고 teamname이 null이 아닐때 해당 team의 captain 수정 -->
create or replace trigger trg_update_leader
after update of grade on team_member
for each row
when (new.grade= '팀장' and new.teamname is not null)
begin
dbms_output.put_line('트리거 실행');
update team set captain = :new.userid where teamname = :new.teamname;
end;
/

<!-- waitteam의 status가 Y로 바꼈을 때 game의 away를 waitteam의 teamname으로 바꿔줌.-->
create or replace trigger trg_waitteam_status_Y
after update of status on waitteam
for each row
when (new.status='Y')
begin
update game set away = :old.teamname where game_no = :old.game_no;
end;
/

<!-- tbl_user에서 삭제한 정보를 멤버 탈퇴 테이블로 옮기는 트리거 -->
create or replace trigger tb_user_delete
after delete on tbl_user
for each row
begin
    insert into tbl_delete_user values (seq_game_no.nextval, :old.userid, :old.password, :old.username,:old.regioncode, :old.phone, :old.profile, :old.photo, sysdate);
end;
/

<!-- member_register에서 yn이 'Y'로 변한 행이 있으면 팀이름과 아이디를 가져다 tbl_user에 수정, trg_add_team_member때문에 team_member에도 추가됨 -->
create or replace trigger member_register_YN
after update of yn on member_register
for each row
when (new.yn = 'Y')
begin
   update tbl_user set teamname = :new.teamname, grade = '팀원' where userid = :new.userid;
end;
/
