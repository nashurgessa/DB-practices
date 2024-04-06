***\**Note :\**\***

In SQL, comparisons involving NULL do not result in true or false but in unknown. This behavior impacts the WHERE clause, which is used to filter rows based on a specified condition. When the condition in the WHERE clause evaluates to unknown for a row, that row is not included in the query results. This is because, for the purpose of filtering rows, SQL treats unknown as false:



\```SQL

Sample Data

ID | Name     | Salary

1| Alice    | 50000

2| Bob      | NULL

3| Charlie  | NULL

--- Query using AND with unknown

SELECT * FROM Employees

WHERE Salary > 40000 AND Salary IS NOT NULL;

This will only return Alice since Bob and Charlie have unknown salaries.



--- Query using OR with unknown



SELECT * FROM Employees

WHERE Salary < 60000 OR Salary IS NULL; 

-- This will return all employees, since Salary being NULL makes the comparison unknown, but the OR condition with IS NULL makes it true for Bob and Charlie.