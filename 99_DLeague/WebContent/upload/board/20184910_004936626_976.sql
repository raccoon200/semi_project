select * from board_region;
select * from board_region where board_region_no = 45;
commit;
delete from board_region;
desc board_region;
insert into board_region values(seq_board_region_no.nextval, 'boardregion1', 'admin', 'G2', 'agkjkjwkgjw', sysdate, 'index.html', 'index.html', 'Y', default);

select * from tbl_user where userid = 'yeon';
alter table tbl_user modify class grade;