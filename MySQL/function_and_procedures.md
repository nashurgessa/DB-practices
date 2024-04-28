
#### Functions
```SQL	
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
```

#### Procedures

```SQL
DELIMITER $$

CREATE PROCEDURE `dept_count_proc`(IN dept_name varchar(20), out d_count integer)
BEGIN
	select count(*) into d_count
    from instructor
    where instructor.dept_name = dept_count_proc.dept_name;
END  $$

DELIMITER ;
```
