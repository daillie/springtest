SET foreign_key_checks = 0;
drop table if exists Attached_tasks,Tasks,Users;
SET foreign_key_checks = 1;

create table Users
(	
	id int not null primary key auto_increment ,
	name varchar(16),
	surname varchar(16),
	age int
);


create table Tasks
(
	id int not null	primary key auto_increment,
	author_id int,
	name varchar(16),
	foreign key (author_id) references Users(id)	
);

create table Attached_tasks
(
	id int not null primary key auto_increment,
	user_id int,
	task_id int,
	foreign key (user_id) references Users(id),
	foreign key (task_id) references Tasks(id)
);


insert into Users(name,surname,age) 
values(
	'kekich',
	'keknuty',
	32
);

