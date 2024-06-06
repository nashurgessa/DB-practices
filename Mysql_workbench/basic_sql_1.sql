select distinct instructor_name from university.instructor;

select all instructor_name from university.instructor;

select 'A' from university.instructor;

-- alter table university.instructor modify column instructor_salary float; --
select instructor_id, instructor_name, instructor_salary / 12 as monthly_salary from university.instructor;


INSERT INTO university.instructor
(instructor_id, instructor_name, 
instructor_salary, dept_name) values(
"1234", "Chala", "20000", "SE");

INSERT INTO university.instructor
(instructor_id, instructor_name, 
instructor_salary, dept_name) values(
"1235", "Nashu", "20000", "CE");

INSERT INTO university.instructor
(instructor_id, instructor_name, 
instructor_salary, dept_name) values(
"1265", "Dr Ajit", "20000", "SE");

select instructor_name
from university.instructor
where dept_id = "SE";

Alter table university.instructor 
 change dept_id dept_name varchar(20);

insert into university.department(
dept_id, dept_name, dept_building) values(
"d_1234", "SE", "D-Building");

insert into university.department(
dept_id, dept_name, dept_building) values(
"c_1234", "CE", "C-Building");

Alter table university.instructor 
drop foreign key instructor_ibfk_1;

Alter table university.instructor
add foreign key (dept_name) 
references department(dept_name);


alter table university.department drop column dept_id;

alter table university.department add column budget varchar(20);

alter table university.department add primary key(dept_name);

alter table university.department drop index dept_name_unique;


INSERT into university.department(dept_name, dept_building, budget) 
values
("Comp. Sci", "C-building", "100000"),
("Software. Eng", "D_building", "100000"),
("E-commerce", "D-building", "90000"),
("Elc. Eng", "Java-building", "120000");

INSERT into university.department(dept_name, dept_building, budget) 
values ("Physics", "Watson", "70000");

INSERT into university.instructor(instructor_id, instructor_name, dept_name, instructor_salary) 
values
("22222", "Einstein", "Physics", 950000), 
("121212", "Chala", "Software. Eng", 100000),
("121213", "Dr Ajit", "Software. Eng", 100000),
("32343", "Dr Baha", "E-commerce", 100000), 
("32344", "Hasha", "Comp. Sci", 150000)
;

ALTER table university.section RENAME COLUMN section_id TO sec_id; 

Alter table university.section drop column section_name;

Alter table university.section drop column instructor_name;

ALTER TABLE university.section add COLUMN (building varchar(20), room_number varchar(20));


INSERT INTO university.section(course_id, sec_id, semester, year_, building, room_number) 
values ("SE-203", "F406", "2-nd", 2024, "F-building", "406");

INSERT INTO university.section(course_id, sec_id, semester, year_, building, room_number) 
values ("SE-203", "F405", "2-nd", 2024, "F-building", "405");

INSERT INTO university.teaches (id,course_id, sec_id, semester, year_)
values("201020", "SE-203", "F405", "2-nd", 2024);






