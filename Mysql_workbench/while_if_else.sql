DELIMITER //
create procedure add_dept(
IN dept_name varchar(20),
IN dept_building varchar(20),
IN budget varchar(20))
begin 
	INSERT INTO department (dept_name, dept_building, budget) 
	VALUES (dept_name, dept_building, budget);
end //
delimiter ;


call add_dept("History", "Building H", "100000");


DELIMITER //
create procedure calculate_factorial(in num int, out result int)
BEGIN 
	declare i int default 1;
    declare fact int default 1;
    
    while i <= num DO
		set fact = fact * i;
        set i = i + 1;
    end while;
    set result = fact;
END //
DELIMITER ;

call calculate_factorial(3, @num);
select @num as result



DELIMITER //

CREATE PROCEDURE find_department_budget(IN dept_name VARCHAR(50), OUT total_budget INT)
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE budget_value INT DEFAULT 0;
    DECLARE total INT DEFAULT 0;
    DECLARE cur CURSOR FOR SELECT budget FROM department WHERE dept_name = dept_name;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO budget_value;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SET total = total + budget_value;
    END LOOP;

    CLOSE cur;
    SET total_budget = total;
END //

DELIMITER ;




CALL find_department_budget('Maths', @total_budget);
SELECT @total_budget AS budget;

DELIMITER // 
create trigger setnull_trigger 
before update on takes	
for each row
 begin 
	if new.grade = '' THEN
		set new.grade = null;
	END IF;
 end //
 delimiter ;
 
SHOW triggers;

SELECT * FROM information_schema.TRIGGERS 
WHERE TRIGGER_NAME = 'setnull_trigger' 
AND TRIGGER_SCHEMA = 'university';
