DELIMITER $$

CREATE FUNCTION dept_count(dept_name varchar(20))
RETURNS INTEGER
READS SQL DATA

BEGIN 
    DECLARE d_count INTEGER;
	SELECT count(*) into d_count
	FROM instructor
	WHERE instructor.dept_name = dept_name;
	RETURN d_count;
END $$

DELIMITER ;






