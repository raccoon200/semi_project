<!-- tbl_user의 teamname과 grade가 바뀌었을때 바뀐 값으로 team_member에 추가하는 트리거 -->
create or replace trigger trg_add_team_member
after update of teamname on tbl_user
for each row
when (new.grade='팀원' and old.grade='선수')
begin
insert into team_member values (:old.userid, :new.teamname, sysdate, :new.grade);
end;
/
<!-- 이런식으로 업데이트 -->
--update tbl_user set teamname='testTeam5', grade='팀원' where userid = 'test20';