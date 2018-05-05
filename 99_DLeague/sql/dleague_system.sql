--user dleague 생성
create user dleague identified by dleague
default tablespace users;
--dleague 권한
grant connect, resource to dleague;