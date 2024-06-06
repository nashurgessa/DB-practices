SELECT * FROM university.section;

alter table course drop foreign key course_ibfk_1;

ALTER TABLE course
ADD foreign key (dept_name) references department (dept_name)
	on delete cascade on update cascade;
    
    
create table person (
	ID char(10) primary key not null,
    name char(40),
    mother char(10),
    father char(10),
    foreign key (father) references person(ID),
    foreign key (mother) references person(ID)
);

-- Insert father 
INSERT INTO person (ID, name) VALUES ("001", "Urgessa");
#Insert Mother
INSERT INTO person (ID, name) VALUES ("002", "Yeshi");
-- Now Insert child
INSERT INTO person (ID, name, mother, father) 
VALUES ("003", "Nashu", "001", "002");

/*Set Father and Mother to NULL Initially, 
Update After Inserting All Persons*/

-- Insert person without specifying parents
INSERT INTO person (ID, name) VALUES ('004', 'Baby Doe');

-- Update the record later when parents' data is available
UPDATE person SET father = '001', mother = '002' WHERE ID = '004';

select * from person;

BEGIN;
	INSERT INTO person (ID, name) VALUES ('005', 'Lila');
    INSERT INTO person (ID, name) VALUES ('006', 'Dawit');
    INSERT INTO person (ID, name, mother, father) VALUES ('007', 'Lillian', '005', '006');
COMMIT;

delete from person where ID = '006';
 
SET foreign_key_checks = 0;
INSERT INTO person (ID, name, mother, father) VALUES ('009', 'Alice', '0010', '0011');
INSERT INTO person (ID, name) VALUES ('0010', 'Bob');
INSERT INTO person (ID, name) VALUES ('0011', 'Carol');
SET foreign_key_checks = 1;

-- Subtracting two dates to get an interval
SELECT TIMESTAMP '2023-04-25 08:00:00' - DATE '2023-04-20';

-- Adding an interval to a date
SELECT TIMESTAMP '2023-04-25 08:00:00' + INTERVAL '5' DAY;

-- Extracting parts of a date
SELECT EXTRACT(YEAR FROM TIMESTAMP '2023-04-25 08:00:00');


-- DAO - Data Access Object
-- JDBC - Java Database Connectivity
