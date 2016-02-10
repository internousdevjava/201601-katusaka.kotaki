drop database if exists struts2;
create database struts2;
use struts2;

create table login_table(
id varchar(255),
password varchar(255)
);

insert into login_table values("test","test");
insert into login_table values("taro","123");
insert into login_table values("jiro","123");
insert into login_table values("hanako","123");