INSERT into university.instructor (instructor_id, instructor_name, instructor_salary, dept_id) 
values ("in_1234", "ABC", 50000, "SE");

SELECT instructor_id, name, salary/12 as monthly_salary FROM university.instructor;

select name from university.instructor;
select * from university.teaches;

select * 
from university.instructor, university.teaches;

select salary 
from university.instructor
where name LIKE '100\%' ;

select name 
from university.instructor
order by dept_name, name ;


select count(distinct instructor_id)
from university.instructor;

select name, course_id
from university.student natural join university.takes;

INSERT INTO university.student(student_id, name, dept_name, tot_cred)
values 
("12345", "Shankar", "Comp. Sci", 32),
("44553", "Peltier", "Physics", 56),
("70557", "Snow", "Physics", 0),
("76654", "Brown", "Comp. Sci", 58),
("76653",  "Aoi", "Elec. Eng", 60),
("98988","Chala", "Elec. Eng", 110)
;

select * from university.department;

Insert into university.department(dept_name, dept_building, budget)
values ("Elec. Eng", "Python-Building", 1200000);

