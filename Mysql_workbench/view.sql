SELECT * FROM instructor;

create view instructor_info as 
	select instructor_id, name, dept_building
    from instructor, department
    where instructor.dept_name = department.dept_name;
    
    
insert into instructor_info (instructor_id, name, dept_building)
values ("09876", "Nashu2", "Taylor");


CREATE VIEW se_instructor as 
	SELECT * 
	FROM instructor
	WHERE dept_name = "SE";

select * from department;

insert into se_instructor (instructor_id, name, salary, dept_name)
values("209876", "Brown", "100000", "CE");

select * from se_instructor;

select * from instructor;

select * from section；
or Code: 1146. Table 'university.section；' doesn't exist

