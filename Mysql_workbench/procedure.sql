DELIMITER //
create procedure dept_count_proc(in dept_name varchar(20), out d_count integer)
begin
	select count(*) into d_count
	from instructor
	where instructor.dept_name = dept_name;
END //
DELIMITER ;