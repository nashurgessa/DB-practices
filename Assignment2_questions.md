

### [Neusoft Institute Guangdong  Logo Here]

----

### Database Systems Assignment 2

**Due Date:** 6th June 2024

---

**Student Information:**</br>
**Name:** [Your Name]</br>
**Student ID:** [Your Student ID]</br>
**Teacher's Name:** Chala Urgessa</br>

---

###### Instructions:
1. **Answer all questions:** Provide detailed explanations and SQL queries where required.
2. **Comment your code:** Ensure your SQL queries and explanations are well-commented.
3. **File submission:** Submit your assignment as a ***.md*** or ***.pdf*** file named ***studentId_DB_Assignment2.md.**
4. **Submission method:** Email your MD/PDF to ***chala@nuit.edu.cn***.
5. **Late submissions:** A penalty of 10% per day will be applied to late submissions.

---

#### Marking Scheme:
|Question	|Marks|
|---------|-----|
|Question 1	|4 marks|
|Question 2	|5 marks|
|Question 3	|5 marks|
|Question 4	|36 marks (divided among sub-questions)|
|Question 5	|16 marks (divided among sub-questions)|
|Question 6	|10 marks (divided among sub-questions)|
|Question 7	|9 marks (divided among sub-questions)|
|Question 8	|8 marks|
|Question 9	|7 marks|


---

**Question 1.** Discuss the differences between `DELETE`, `TRUNCATE`, and `DROP` commands in SQL. Provide examples of when to use each command. **[4 marks]**

```text



```

**Question 2** Describe the concept of a foreign key and its importance in relational databases. Write an SQL statement to add a foreign key constraint to an existing table. **[5 marks]**

```text



```

**Question 3** Explain the ACID properties in the context of database transactions. Provide an example for each property. **[5 marks]**

```text


```

---

**Question 4.** Given the following relational schema and relational algebra, write the SQL query to answer the following queries.    **[36 marks]**

Relational schema of question 1.

> Product(<u>model</u>, maker, type)
>
> PC(<u>model</u>, speed, ram, hd, price)
>
> Laptop(<u>model</u>, speed, ram, hd, screen, price)
>
> Printer(<u>model</u>, color, type, price)

The sample data for relations of question 1. These data are not used to calculate results of following questions.

Product:

| model | maker | type    |
| ----- | ----- | ------- |
| 1001  | A     | PC      |
| 3001  | B     | Printer |
| 2001  | C     | Laptop  |

PC:

| model | speed | ram  | hd  | price |
| ----- | ----- | ---- | --- | ----- |
| 1001  | 2.66  | 1024 | 250 | 2114  |
| 1002  | 1.42  | 512  | 250 | 955   |
| 1003  | 3.20  | 2048 | 160 | 1049  |

Laptop:

| model | speed | ram  | hd  | screen | price |
| ----- | ----- | ---- | --- | ------ | ----- |
| 2001  | 2.00  | 1024 | 250 | 15     | 2114  |
| 2002  | 1.73  | 512  | 80  | 24     | 955   |
| 2003  | 1.83  | 2048 | 60  | 20     | 1049  |

Printer:

| model | color | type    | price |
| ----- | ----- | ------- | ----- |
| 3001  | true  | ink-jet | 99    |
| 3002  | false | laser   | 239   |
| 3003  | true  | laser   | 899   |

**Answer DB- ? 4+ -> database\mettu/Assignment2solution.pdf**

(a) What PC models have a speed of at least 3.00?  **[3 marks]**

$\pi_{model}(\sigma_{model \geq 3.00}(PC))$

```sql


```

(b) Find the model numbers of all color laser printers.  **[3 marks]**

$\pi_{model}(\sigma_{type=laser \land color=true}(Printer))$

```sql


```

(c) Which manufacturers make laptops with a hard disk of at least 100GB?  **[3 marks]**

$\pi_{maker}(Product \Join \sigma_{hd=laser \geq 100}(Laptop))$

```sql



```

(d)  Find the model number and price of all products (of any type) made by manufacturer B.  **[3 marks]**

**$\pi_{\text{model, price}}\left(\sigma_{\text{maker} = B}(\text{Product})\right)
\Join
\left(
  \pi_{\text{model, price}}(\text{PC})
  \cup
  \pi_{\text{model, price}}(\text{Laptop})
  \cup
  \pi_{\text{model, price}}(\text{Printer})
\right)$**

```sql



```

(e) Find those manufacturers that sell Laptops, but not PC’s.   **[4 marks]**

$\pi_{maker}(\sigma_{type=Laptop}(Product)) - \pi_{maker}(\sigma_{type=PC}(Product))$

```sql



```

(f) Find those manufacturers that sell all models of PCs and lazer Printers.    **[ 4marks]**

$\pi_{\text{maker}}\left( \text{Product} / \left( \pi_{\text{model}}(\text{PC}) \cup \pi_{\text{model}}(\sigma_{\text{type} = 'lazer'}(\text{Printer})) \right) \right)$

```sql



```

(g) Find those manufacturers whose laptops have all ram sizes that manufacturer B’s laptops have.    **[4 marks]**

$(
  \pi_{\text{maker, ram}}\left(\text{Product} \Join \text{Laptop}\right)) / \pi_{\text{ram}}\left(\sigma_{\text{maker} = B}(\text{Product}) \Join \text{Laptop}\right))$

```sql



```

(h) Find those manufacturers of at least two different computers   **[4 marks]**

$ \begin{aligned}
&\rho(\text{TEMP1}, \pi_{\text{model}}(\sigma_{\text{speed} \geq 2.80}(\text{PC})) \cup \pi_{\text{model}}(\sigma_{\text{speed} \geq 2.80}(\text{Laptop}))) \\
&\rho(\text{TEMP2}, \text{Product} \Join \text{TEMP1}) \\
&\pi_{\text{maker}}\left(\sigma_{\text{TEMP2.maker} = \text{TEMP3.maker} \land \text{TEMP2.model} \neq \text{TEMP3.model}}(\text{TEMP2} \times \rho(\text{TEMP3}, \text{TEMP2}))\right)
\end{aligned} $

```sql



```

(i) Find the manufacturers of PC’s with at least two different speeds.     **[4 marks]**

$\pi_{\text{R1.maker}}\left(\sigma_{\text{R1.speed} \neq \text{R2.speed} \land \text{R1.maker} = \text{R2.maker}}\left(\rho(\text{R1}, (\text{Product} \Join \text{PC})) \times \rho(\text{R2}, (\text{Product} \Join \text{PC}))\right)\right)$

```sql



```

(j) Find the manufacturers who sell exactly two different models of PC.   **[4 marks]**

$\pi_{\text{R1.maker}}\left(
  \sigma_{\text{R1.model} \neq \text{R2.model} \land \text{R1.maker} = \text{R2.maker}}\left(
    \rho(\text{R1}, (\text{Product} \Join \text{PC})) \times
    \rho(\text{R2}, (\text{Product} \Join \text{PC}))
  \right)
\right) - \pi_{\text{R1.maker}}\left(
  \sigma_{\text{R1.model} \neq \text{R2.model} \land \text{R1.model} \neq \text{R3.model} \land \text{R2.model} \neq \text{R3.model} \land \text{R1.maker} = \text{R2.maker} \land \text{R1.maker} = \text{R3.maker}}\left(
    \rho(\text{R1}, (\text{Product} \Join \text{PC})) \times
    \rho(\text{R2}, (\text{Product} \Join \text{PC})) \times
    \rho(\text{R3}, (\text{Product} \Join \text{PC}))
  \right)
\right) $

```sql



```

---

##### For Questions 5-9, use the following Orders table to answer the questions. [50 marks]

| OrderID | CustomerName  | ProductID | ProductName | Quantity | UnitPrice | OrderDate  |
| ------- | ------------- | --------- | ----------- | -------- | --------- | ---------- |
| 1       | John Doe      | P01       | Widget      | 5        | 10.00     | 2024-05-01 |
| 1       | John Doe      | P02       | Gadget      | 2        | 20.00     | 2024-05-01 |
| 2       | Jane Smith    | P01       | Widget      | 1        | 10.00     | 2024-05-03 |
| 3       | Alice Johnson | P03       | Doodad      | 3        | 15.00     | 2024-05-05 |

**Question 5:** Given the following unnormalized table Orders: **[16 marks]**

a. Identify the functional dependencies. **[4 marks]**

```plaintext



```

b. Normalize the table to 1NF, 2NF, and 3NF. Provide the resulting tables for each step. **[12 marks]**

```plaintext



```

**Question 6:** Nested Queries **[10 marks]**
a. Write a nested SQL query to find the names of customers who have ordered more than the average quantity of any product. **[5 marks]**

```plaintext



```

b. Write a nested SQL query to find the products that have never been ordered. **[5 marks]**

```plaintext



```

**Question 7:** Indexing **[9 marks]**
a. Consider the Orders table. Explain the purpose of indexing and create an index on the OrderDate column. **[4 marks]**

```plaintext


```

b.  Create a composite index on the ProductID and OrderDate columns and explain how it can improve query performance. **[5 marks]**

```plaintext



```

**Question 8:** Write a trigger that automatically updates the stock quantity in the Products table whenever a new order is inserted in the Orders table. **[8 marks]**

```sql



```

**Question 9:** Create a user-defined function `TotalOrderValue` that takes an `OrderID` as input and returns the total value of that order. **[7 marks]**

```plaintext



```
