
select *
from course natural left outer join prereq
union
select *
from course natural right outer join prereq;

select c.course_id as course_id, c.title as title, p.prereq_id as prereq_id
FROM course as c NATURAL LEFT OUTER JOIN prereq as p
union
select c.course_id as course_id, c.title as title, p.prereq_id as prereq_id
FROM course as c NATURAL RIGHT OUTER JOIN prereq as p;

select * 
FROM course inner join prereq
ON course.course_id = prereq.prereq_id;

select * 
FROM course left outer join prereq
ON course.course_id = prereq.prereq_id;
