select * from section;

insert into section (sec_id, course_id, room_number, 
building, semester, year_) values 
("F205", "CS-102", "205" , "F-building", "Fall", 2017),
("H302", "CS-101", "302", "H-building", "Spring", 2018),
("H209", "MATH-222", "209", "H-building", "Fall", 2017),
("A209", "MATH-222", "209", "A-Building", "Fall", 2018),
("A204", "PHY-123", "204", "A-Building",  "Spring", 2018),
("B304", "CS-101", "304", "B-Building", "Fall", 2018);

insert into section (sec_id, course_id, room_number, 
building, semester, year_) values 
("H302", "CS-101", "302", "H-building", "Fall", 2017);

SELECT course_id
FROM section as S
WHERE semester = "Fall" and year_ = 2017
AND EXISTS ( Select * 
			From section AS T
			WHERE semester = "Spring" and year_ = 2018 
            and S.course_id = T.course_id);
