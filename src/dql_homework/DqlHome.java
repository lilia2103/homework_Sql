package dql_homework;

create database company;
        \c company;

        create table MOCK_DATA (
        EMPLOYEE_ID INT NOT NULL,
        Name VARCHAR(50) NOT NULL,
        Gender VARCHAR(50) NOT NULL,
        Position VARCHAR(50) NOT NULL,
        Department VARCHAR(50) NOT NULL,
        Office VARCHAR(50) NOT NULL,
        Age INT NOT NULL,
        Start DATE,
        Salary VARCHAR(50) NOT NULL
        );


        create table PROJECTS (
        Project_ID INT,
        Project_Name VARCHAR(50),
        Department VARCHAR(50),
        Start_Data DATE,
        End_Data DATE
        );


// 1. Select all columns from the "Employee" table:
// select * from employee ; (իմ մոտ mock_data -ե):

// 2. Select all unique values from the "Department" column in the "Employee" table:
// selcet distingt department from mock_data;

// 3. Select all employees whose position is "Sales Manager":

// Select all employees whose position is "Sales Manager":

// 4. Select all female employees who work in the "Marketing" department or whose position is "HR Director":

// select * from mock_data where gender = 'Female' and department = 'Marceting' or position = 'HR Director';


// 5. Select all employees from the "Sales" department, ordered by their salary in descending order:

// select * from mock_data where department = 'Sales' order by salary desc;

// 6. Select all employees whose position is either "Software Eng" or "Accountant":

// select * from mock_data where position = 'Software Eng' or position = 'Accountant'

// 7. Select all employees whose age is between 30 and 40:

// select * from mock_data where age between 30 and 40;

// 8. Select the department and the highest salary for each department:

// select department, salary as 'Highest Salary' from mock_data where salary in (select max(salary) from mock_data group by department);


// 9. Select the average salary for all employees who started after 2018:

// select avg(replace(salary,'$',''):: numeric) as "Average Salary"
        from mock_data where start > '01.01.2018';


// 10. Select all projects that start after January 1st, 2023 and end before December 31st, 2023:

// select * from projects where start_data > '2023-01-01' and end_data < '2023-12-31';

// 11. Select all projects that started between January 1st, 2022 and December 31st, 2022:

// select * from projects where start_data between '2023-01-01' and '2023-12-31';
