--==========================
--spring security
--==========================

--member
select * from member;

desc member;

--authority 테이블 생성

create table authority(
    id varchar2(20) not null,               --회원 아이디
    authority varchar2(20) not null,        --권한
    constraint pk_authority primary key (id, authority), --복합 primarykey
    constraint fk_authority_member_id foreign key(id) references member(id)
);

--honggd, ROLE_USER
--honngd, ROLE_ADMIN

insert into authority values('qwerty','ROLE_USER');
insert into authority values('abcde','ROLE_USER');
insert into authority values('admin','ROLE_USER');
insert into authority values('admin','ROLE_ADMIN');

select * from authority;

commit;

--회원정보 조회
select * from member where id='admin';

--회원권한 조회
select
    *
from 
    authority
where
    id ='admin';

--security의 remember-me 사용을 위한 persistent_logins테이블생성
create table persistent_logins(
    username varchar2(64) not null,
    series varchar2(64) primary key, --pk
    token varchar2(64) not null, --username, password, expirytime에 대한 hashing값
    last_used timestamp not null
);


select * from persistent_logins;
