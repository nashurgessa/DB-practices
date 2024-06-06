create database ecommerce;

create table ecommerce.customers(
customer_id varchar(20) not null primary key,
customer_name varchar(20));


create table ecommerce.orders(
order_id varchar(20) primary key,
customer_id varchar(20),
order_amount numeric(9, 1),
foreign key (customer_id) references customers(customer_id));

insert into ecommerce.customers(customer_id, customer_name)
values ("1", "Alice"), 
("2", "Bob"), 
("3", "Charlie");

insert into ecommerce.orders (order_id, customer_id, order_amount) 
values ("101", "1", 250),
 ("102", "2", 450),
 ("103", "1", 200),
 ("104", "3", 150);
 
 
SELECT * FROM ecommerce.customers
WHERE customer_id IN (SELECT customer_id FROM ecommerce.orders);

SELECT * FROM ecommerce.customers as C
WHERE EXISTS (SELECT 1 FROM ecommerce.orders as O
				WHERE O.customer_id = C.customer_id);
                
                
			
Select * from university.teaches;
Select * from university.takes;

select name, title
from student natural join takes, course
where takes.course_id = course.course_id;

select name, title 
from student natural join takes natural join course;

select * from takes;

select * from student, takes, course;

insert into takes (id, course_id, sec_id, semester, year_, grade)
values("00128", "CS-101", "H302", "Spring", 2018, "A"), 
("12345", "CS-101", "B304", "Fall", 2018, "A");

insert into takes (id, course_id, sec_id, semester, year_, grade)
values("00128", "MATH-222", "H209", "Fall", 2017, "A");

update takes 
set course_id="MATH-222", sec_id="H209", semester="Fall", year_=2017, grade="A"
where id="00128";









