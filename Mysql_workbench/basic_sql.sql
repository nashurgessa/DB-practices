create database university;

create table university.department(dept_id varchar(20) primary key not null, 
dept_name varchar(20), dept_building varchar(20));

create table university.instructor(instructor_id varchar(20) primary key not null, 
instructor_name varchar(20), instructor_salary float,
 dept_id varchar(20));
 
 

ALTER table university.department 
add CONSTRAINT dept_name_unique UNIQUE (dept_name);


create table university.course(
course_id varchar(20) not null primary key, 
title varchar(50),
dept_name varchar(20),
credits numeric(2, 0),
foreign key (dept_name) references university.department(dept_name));


create table university.student(
student_id varchar(20) not null primary key,
name varchar(20) not null,
dept_name varchar(20),
tot_cred numeric(3, 0),
foreign key (dept_name) references department(dept_name));

drop table university.section;

create table university.section(
sec_id varchar(20),
course_id varchar(20),
room_number varchar(20),
building varchar(20),
semester varchar(20),
year_ numeric(4, 0),
unique (sec_id, course_id, semester, year_)
);

ALTER TABLE university.section add CONSTRAINT UNIQUE(sec_id, course_id, semster, year);

ALTER TABLE university.section drop primary key;


drop table university.takes;
drop table university.section;
drop table university.teaches;




alter table university.section add primary key(section_id, course_id, semster, year);

create table university.takes(
id varchar(20) primary key not null,
course_id varchar(20),
sec_id varchar(20),
semester varchar(20),
year_ numeric (4, 0),
grade varchar(2),
foreign key (id) references university.student(student_id),
foreign key (sec_id, course_id, semester, year_) 
references university.section(sec_id, course_id, semester, year_)
);

ALTER TABLE university.section
ADD PRIMARY KEY (course_id, section_id, semester, year);


ALTER table university.takes 
add constraint weak_foreign_key 
foreign key (course_id, section_id, semster, year) 
references university.section(course_id, section_id, semster, year);



Alter table university.section ADD CONSTRAINT UNIQUE(sec_id, course_id, semester, year);


create table university.teaches(
id varchar(20) not null primary key,
course_id varchar(20),
sec_id varchar(20), 
semester varchar(20),
year_ numeric(4, 0),
foreign key(sec_id, course_id, semester, year_) 
references university.section(sec_id, course_id, semester, year_)
);



ALTER TABLE university.instructor RENAME COLUMN instructor_name TO name;

ALTER TABLE university.instructor RENAME COLUMN instructor_salary TO salary;




 
ALTER table university.instructor add foreign key (dept_id) references university.department(dept_id);

ALTER table university.instructor add instructor_qaulification varchar(20);

ALTER table university.instructor drop instructor_qaulification;

ALTER table university.instructor Modify instructor_salary varchar(20) NULL;