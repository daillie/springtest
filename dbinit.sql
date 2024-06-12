SET foreign_key_checks = 0;
drop table if exists Attached_Tasks,Tasks,Users;
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
	name varchar(16),
	description text,
	expiration_date DateTime	
);

create table Attached_Tasks
(
	id int not null primary key auto_increment,
	user_id int,
	task_id int,	
	creator_id int,
	foreign key (creator_id) references Users(id),
	foreign key (user_id) references Users(id),
	foreign key (task_id) references Tasks(id)
);


-- test USERS --
insert into Users(name,surname,age) 
values('Kekich','Testovy',1337),('Loh','zhmihovy',228);


-- test TASKS
insert into Tasks(name, description, expiration_date) values
(
	'Keknyt',
	'zhestko nakekat',
	NOW()
);

-- test many to many tasks
insert into Attached_Tasks(user_id, task_id, creator_id) values
(2,1,1),(1,1,1);