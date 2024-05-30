
DELIMITER //

create procedure student_diplayer()
BEGIN
	SELECT * from student;
END //

DELIMITER ;


call student_diplayer();





SHOW CREATE PROCEDURE dept_count_proc;


