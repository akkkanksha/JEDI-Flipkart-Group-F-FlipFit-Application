create table customer(
customerid int primary key,
name varchar(255) not null,
userid int,
address varchar(255) not null,
foreign key (userid) references User(userid)
);