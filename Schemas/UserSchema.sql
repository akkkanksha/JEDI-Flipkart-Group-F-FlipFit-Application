create table User(
username varchar(255) not null,
userid int primary key,
roleid int,
password varchar(255) not null,
foreign key (roleid) references Role(roleid)
)