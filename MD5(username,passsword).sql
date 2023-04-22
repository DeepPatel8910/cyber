create table UserNamePasswordDemo(
U_Id int(10) unsigned NOT NULL AUTO_INCREMENT primary key,
UserId varchar(255) DEFAULT NULL unique key,
UserPassword varchar(255) DEFAULT NULL
);


insert into UserNamePasswordDemo(UserId,UserPassword) values('om@gg.com',MD5('om1234'));
insert into UserNamePasswordDemo(UserId,UserPassword) values('raju@gg.com',MD5('raju1234'));
insert into UserNamePasswordDemo(UserId,UserPassword) values('magan@gg.com',MD5('magan1234'));

Select * from UserNamePasswordDemo;
