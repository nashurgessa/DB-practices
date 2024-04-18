## Creating Database

create database/Schema university

## Creating Table
/* Creating table department */
```sql
create table university.department(dept_id varchar(20) primary key not null, 
dept_name varchar(20), dept_building varchar(20));
```

/* Creating table course*/
```sql
create table university.course(course_id varchar(20) not null primary key, 
title varchar(50), dept_name varchar(20), credits numeric(2, 0),
foreign key (dept_name) references university.department(dept_name));
```

/* creating table student */
```sql
create table university.student(student_id varchar(20) not null primary key,
name varchar(20) not null, dept_name varchar(20), tot_cred numeric(3, 0),
foreign key (dept_name) references department(dept_name));
```

/*creating table section*/
```sql
create table university.section(
sec_id varchar(20),
course_id varchar(20),
room_number varchar(20),
building varchar(20),
semester varchar(20),
year_ numeric(4, 0),
unique (sec_id, course_id, semester, year_)
);
```

/*creating  table takes*/
```sql
create table university.takes(
id varchar(20) primary key not null,
course_id varchar(20),
sec_id varchar(20),
semester varchar(20),
year_ numeric (4, 0),
grade varchar(2),
foreign key (id) references university.student(student_id),
foreign key (sec_id, course_id, semester, year_) 
references university.section(sec_id, course_id, semester, year_)
);
```

/*creating teaches tables*/
```sql
create table university.teaches(
id varchar(20) not null primary key,
course_id varchar(20),
sec_id varchar(20), 
semester varchar(20),
year_ numeric(4, 0),
foreign key(sec_id, course_id, semester, year_) 
references university.section(sec_id, course_id, semester, year_)
);
```

---

### Creating a recursive table
between course and prereq

course(course_id(pk), title, dept_name, credits)
prereq(course_id(pk)m prereq_id(pk))

```sql
create table university.prereq(
course_id varchar(20),
prereq_id varchar(20),
primary key(course_id, prereq_id),
FOREIGN KEY (course_id) REFERENCES 
university.course(course_id) ON DELETE CASCADE,
FOREIGN KEY (prereq_id) REFERENCES 
university.course(course_id) ON DELETE CASCADE
);
```

---

## Altering
/* Adding foreign key to the table  (1)*/
Alter table university.instructor
add foreign key (dept_name) 
references department(dept_name);

/* Adding foreign key to the table  (2)*/
ALTER table university.takes 
add constraint weak_foreign_key 
foreign key (course_id, section_id, semster, year) 
references university.section(course_id, section_id, semster, year);

/* Dropping foreign by foreign_key name */
Alter table university.instructor 
drop foreign key instructor_ibfk_1;

/* Adding primary key to the table */
alter table university.department add primary key(dept_name);

/ * Adding composite key to the table */
ALTER table university.section 
add primary key(section_id, course_id, semster, year);

/* Adding unique contraint to the column  */
ALTER table university.department 
add CONSTRAINT dept_name_unique UNIQUE (dept_name);

/* Adding new column to the table */
alter table university.department add column budget varchar(20);

/* Adding Multiple column to the table */
ALTER TABLE university.section add COLUMN (building varchar(20), room_number varchar(20));

/* Dropping column from the table*/
alter table university.department drop column dept_id;

/* Dropping the unique constraint*/
alter table university.department drop index dept_name_unique;

/* Rename a column name */
ALTER table university.section RENAME COLUMN section_id TO sec_id; 

---

## Dropping table */
drop table university.section;

---

## Insertion 

INSERT into university.department(dept_name, dept_building, budget) 
values ("Physics", "Watson", "70000");

INSERT into university.department(dept_name, dept_building, budget) 
values
("Comp. Sci", "C-building", "100000"),
("Software. Eng", "D_building", "100000"),
("E-commerce", "D-building", "90000"),
("Elc. Eng", "Java-building", "120000");

INSERT into university.instructor(instructor_id, instructor_name, dept_name, instructor_salary) 
values
("22222", "Einstein", "Physics", 950000), 
("121212", "Chala", "Software. Eng", 100000),
("121213", "Dr Ajit", "Software. Eng", 100000),
("32343", "Dr Baha", "E-commerce", 100000), 
("32344", "Hasha", "Comp. Sci", 150000)
;


INSERT INTO university.section(course_id, sec_id, semester, year_, building, room_number) 
values ("SE-203", "F406", "2-nd", 2024, "F-building", "406"),
 ("SE-203", "F405", "2-nd", 2024, "F-building", "405");

## Delete
Delete from university.instructor;