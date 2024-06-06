select * from university.student;

create table university.prereq(
course_id varchar(20),
prereq_id varchar(20),
primary key(course_id, prereq_id),
FOREIGN KEY (course_id) REFERENCES 
university.course(course_id) ON DELETE CASCADE,
FOREIGN KEY (prereq_id) REFERENCES 
university.course(course_id) ON DELETE CASCADE
);

select * 
from university.course inner join university.prereq;


(SELECT course.course_id, prereq.prereq_id
FROM university.course
LEFT JOIN university.prereq ON course.course_id = prereq.course_id)
UNION
(SELECT course.course_id, prereq.prereq_id
FROM university.course
RIGHT JOIN university.prereq ON course.course_id = prereq.course_id);
 

create view university.faculty as 
select instructor_id as ID, name, dept_name
from university.instructor;

drop view university.facult;

select * 
from university.faculty;


create view university.departments_total_salary(dep_name, total_salary) as
select dept_name, sum(salary)
from university.instructor
group by dept_name;

select * 
from university.faculty;

insert into university.faculty
values ("30765", "Stephen", "Biology");

select * 
from university.instructor;
