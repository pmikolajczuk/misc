create database restdb;

use restdb;
create table alien (
	id int PRIMARY KEY,
	name varchar(20),
	points int
);

select * from alien;