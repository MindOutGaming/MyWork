/*
Objectives:

1, basic select statement
2, joins, sub-queries
3, procedures
4, functions
5, triggers
6, cursors
*/

-- Session 1 - 08-Nov-2023
-- Basic Select statements

-- What is Data?
-- Data is relevant information which is stored for decision purpose.

-- How to store Data?
-- store it in a computer file, physical file and use a database.

-- problems: 
-- physical file: searching, data lost, accuracy, maintenance, security
-- excel file: compatibility, scheduled backup, accuracy, security

-- db:
-- security (grant and revoke), accuracy (constraints), searching (SELECT statement)

-- MySQL and Oracle

-- DB: logical level, physical level

-- logical level: schemas, db objects 
-- (tables, views, procedures,functions,indexes, triggers, sequences, synonyms)
-- table is the db object where you can store data.


-- physical level
-- data is actually stored in the form of files
-- .dbf (database file), .ctl (control files - log informations, type of segments, etc.)

-- in the form of blocks - 8 kb

-- SQL : Procedural language  : What I want

select * from employees;

-- python / java

-- open the file: open, filereader
-- loop until we get the empty line
-- print the content

/*
projection: specific attributes
selection: specific rows
joining: combine the two or more tables.
*/

select emp_id, first_name
from employees;

SELECT EMP_ID, FIRST_NAME
FROM EMPLOYEES;

select * from dual;

-- mysql: from clause optional
-- oracle: from clause obligatory

select 1 + 1 from dual;

select * from employees;

select * from employees where emp_id = '1233';

desc employees;

describe employees;

select * from employees where emp_id = 1233;

-- column aliases
-- mysql: double quotes and single quotes interchangably
select emp_id as "empno", first_name as name,
last_name as "Surname with a style"
from employees;

-- alternative quote character
select 'I am living in '||' Surat' from dual;

select q'[Today is my father's birthday]' from dual;

select q'#Today is my father's birthday#' from dual;

select * from employees;

-- Nirav Desai's Salary is 7312.996
select first_name||' '||last_name||q'['s Salary is ]'||salary as "Text"
from employees;

-- Session 2: 09-Nov-2023
-- expressions

select salary, salary * 12 as "Annual Salary" from employees;

select * from employees
where salary * 12 > 80000;

select * from employees
where salary * 12 > 8000 * 12;

desc employees;

select hire_date, hire_date + 30
from employees;
-- DD-MM-RR
-- 25-03-17
-- 25-03-1917 or 25-03-2017 or 25-03-2117

select * from employees
where hire_date + 30 >= '25-03-17';

-- operators
-- in
select * from employees
where job_id in (105, 102);

select * from employees
where job_id = 105 or job_id = 102;

-- OR operator: logical operator
-- if all the conditions are false, then false, otherwise true.
/*
T T T
T F T
F T T
F F F
*/

select emp_id, first_name, last_name, 
experience * 12 as "exp in months" from employees;

select 1 / 0 from dual;

select 1 / null from dual;

select * from employees where 1 = 1;
select true or false; -- true
select false or null; -- null
select null or null; -- null

select emp_id, first_name, last_name, salary, 
((nvl(comm_pct, 0) / 100) * salary * 12) as "Annual Incentive"
from employees;

-- substitution variables
select * from employees
where first_name = &first_name
and salary > &salary;

-- Session 3
-- Selection (15-NOV-2023)
-- functions
-- order by
-- group by

-- nvl : null => default value
-- functions are reusable code that accepts some input parameters and return a single value.
-- length: length of the column values
-- niteen: 6
select first_name, length(first_name)
from employees;

select * from employees
where length(last_name) >= 8;

-- trim: leading and trailing spaces
-- " sohel" : leading space with sohel
-- "sohel " : trailing space with sohel
-- " sohel " : both leading and trailing spaces
select first_name, length(first_name), trim(first_name), length(trim(first_name))
from employees;

select * from employees;

-- Nirav : ' Nirav  '
update employees set first_name = ' '||first_name||' ';

select first_name, trim(leading ' ' from first_name)
from employees;

select first_name, trim(trailing ' ' from first_name)
from employees;

select first_name, trim(both ' ' from first_name)
from employees;

update employees set first_name = first_name||',';

select * from employees;

select first_name, trim(trim(trailing ',' from first_name))
from employees;

-- lpad, rpad
select * from employees;

update employees set first_name = trim(trim(trailing ',' from first_name));

-- ###Nirav
-- ###Sohel
-- Zamiruddin
select first_name, lpad(first_name, 10, '#'), rpad(first_name, 10, '#')
from employees;

-- round and trunc
-- months_between


select first_name, last_name, hire_date, hire_date + 7, hire_date - 7
from employees;

-- Date + Number = Date
-- Date - Date = Number
-- Date - Number = Date
-- Date + Date = not allowed.

select sysdate from dual;

select 
first_name,
hire_date, 
round(months_between(sysdate, hire_date), 0) as "age in the months", 
sysdate - hire_date 
as "age in the company"
from employees;

select 
first_name,
hire_date, add_months(hire_date, 7)
from employees;

-- sorting the data.
-- for sorting the data in mysql or oracle or sql server or postgresql: order by

select * from employees
order by salary desc;

select * from employees
order by salary;

select * from employees
order by last_name desc;

select * from employees
order by lower(last_name) desc;

select first_name, last_name, hire_date, salary from employees
order by 3 desc;

update employees set salary = salary + 1500 where emp_id in ('1774');

-- first_name is same, sort it according to salary, sort it according to hire_date
select emp_id, first_name, last_name, hire_date, salary from employees
order by first_name desc, salary desc, hire_date;

-- group by
-- si so
-- length('sohel'): 5
-- mi so : aggregate functions: non null values
-- sum(10, 20, 30, 40): 100
select sum(salary) from employees;

-- avg, count, min, max
select sum(salary), avg(salary), count(*), min(salary), max(salary) 
from employees;

select * from employees;

-- whole data set: are made up of categories
-- avg salary according to department / department wise
-- group by
select D_ID, avg(salary)
from employees
group by D_ID;

-- Session 4 (16-Nov-2023)
-- Group by
-- group by with having.
-- Joins

-- group by: 
select D_ID, count(*)
from employees
group by D_ID;

-- multilevel grouping
select * from employees;

-- deptid and jobid wise
select D_ID, job_id, count(*)
from employees
group by D_ID, job_id;

select D_ID, job_id, count(*)
from employees
group by job_id, D_ID;

-- where is used for selection: group by will get filtered rows.
-- having : to be used for the aggregate function's value.

select D_ID, count(*), avg(salary) from employees
where D_ID in (2, 3, 8)
group by D_ID;

select D_ID, count(*), avg(salary) from employees
where D_ID in (2, 3, 8)
group by D_ID
having count(*) >= 2;

-- DD-MON-RR
-- what is the meaning of RR?
-- rollup, cube

-- % : any number of characters
-- _ : any one character

select * from employees
where first_name like 'S%';

select * from employees
where lower(first_name) like '_h%';

select * from employees
where last_name like 'Des![^%]';

SELECT * FROM EMPLOYEES WHERE LAST_NAME not LIKE '%Des!%%' ESCAPE '!';

SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE 'Des\%' ESCAPE '\';

SELECT first_name, last_name
FROM employees
WHERE last_name LIKE 'De%'
AND NOT REGEXP_LIKE(last_name, '^Des[^a-zA-Z]');

-- joins

-- selecting data from more than one table.

select * from employees;


select * from departments;

-- first_name, last_name, salary, dept name
select first_name, last_name, salary, D_Name
from employees join departments
on employees.D_ID = departments.D_ID;


-- table1: transactid
-- table2: br_id, tr_id

select first_name, last_name, salary, D_Name, e.D_ID
from employees e join departments d 
on e.D_ID = d.D_ID;

-- D_name, # of employees
SELECT d.D_NAME,COUNT(*) FROM employees e
INNER JOIN departments d ON e.D_ID=d.D_ID 
GROUP BY d.D_NAME;

select D_ID, count(*) from employees
group by D_ID;


select * from departments where D_ID is null;

-- inner join: common rows that satisfies the condition.
-- left join, right join: all data from left / right and common data from right / left.
SELECT d.D_NAME, e.emp_id, e.first_name, d.D_ID FROM employees e
LEFT JOIN departments d ON e.D_ID=d.D_ID;

select * from employees where emp_id = 109;

select * from departments where D_ID = 40;

-- bugs: difference between what we want and what we have.
-- technical, data
select * from employees where D_ID is null;
select * from departments where D_ID is null;

-- Session 5 (17-Nov-2023)
-- Joins

select * from employees;
-- first_name, last_name, manager_name
-- Nirav, Des%ai, Mith

-- employees: e, e.manager_id
-- employees: m, m.emp_id
select e.first_name, e.last_name, m.first_name
from employees e join employees m
on e.manager_id = m.emp_id;

select e.first_name, e.last_name, m.first_name
from employees e left join employees m
on e.manager_id = m.emp_id
where m.first_name is null;

select * from locations; -- Location_ID, Country_ID
select * from countries; -- Country_ID, Country_Name
select * from employees; -- D_ID
select * from departments; -- D_ID, Location_ID
-- first_name, country_name
select e.first_name, c.country_name
from employees e join departments d
on e.D_ID = d.D_ID
join locations l on l.location_id = d.location_id
join countries c on c.country_id = l.country_id;

select * from departments;

-- Subqueries
select * from employees;

select salary from employees
where TRIM(first_name) = 'Monika';


-- sub query returns more than one row.
select * from employees where salary > (
select salary from employees
where TRIM(first_name) = 'Monika');


-- >, <, >=, <=, =, <>
-- only works with scalar value but we can modify it using 'all' and 'any'

-- in
-- multiple values
select * from employees where salary in (
select salary from employees
where TRIM(first_name) = 'John');

select * from employees where salary not in (
select salary from employees
where TRIM(first_name) = 'John');

select * from employees where salary > all (
select salary from employees
where TRIM(first_name) = 'John');

select salary from employees where trim(first_name) = 'John';

-- > all (10,20,30): > 30
-- > any (10, 20, 30): > 10
select * from employees where salary > all (3000, 4000, 6000);

select * from employees;

select * from employees
where COMM_PCT in (1, 3, 5);

select * from employees
where COMM_PCT not in (1, 3, 5, null);

select sysdate from dual;

select trunc(23.395, 2), trunc(23.395, -1), trunc(23.395, 0) from dual;

select round(23.395, 2), round(23.395, -1) from dual;

select D_ID, count(*) from employees
group by rollup(D_ID);

select D_ID, job_id, count(*) from employees
group by cube(D_ID, job_id);

-- Session 6 (18-Nov-2023)
-- Derived Tables

-- joins: data from more than one table
-- sub query: result from one query (inner) can be used in another query (outer).

-- manager name, # of employees they are managing.
select * from employees;
-- Mith, 10
-- Ajit, 5
-- Monika, 1
Select m.first_name, count(m.emp_id)
from employees m join employees e
on m.emp_id  = e.manager_id
group by m.first_name;

-- Derived Tables
select * from (select 1 from dual);

select first_name from (select emp_id, first_name from employees);

select * from locations;
select * from countries;

select d.D_Name, lc.country_name
from 
(select l.location_id, country_name from countries c join locations l
on c.country_id = l.country_id) lc join departments d
on d.location_id = lc.location_id;

select d.D_name, c.country_name
from departments d join locations l
on d.location_id = l.location_id
join countries c on c.country_id = l.country_id;

-- What is PL/SQL
-- Procedural language - SQLs

-- Why we need PL/SQL
-- SQL : what
select first_name from employees where first_name = 'Mith';

-- Java, Python: how
-- variables, loops, conditional statements, exception handling

-- PL/SQL = SQL + Procedural language syntax
-- SQL Server: T-SQL (similar to C#)
-- MySQL, Oracle

-- Anonymous Blocks in PL/SQL

set serveroutput on

declare
v_firstname varchar2(45);
begin
select first_name into v_firstname from employees where first_name = 'Mith';
exception
when no_data_found then
dbms_output.put_line('No data found');
end;

declare
v_firstname varchar2(45);
v_lastname varchar2(45);
begin
select first_name, last_name
into v_firstname, v_lastname from employees where trim(first_name) = 'Mith';
dbms_output.put_line('First Name: '||v_firstname);
dbms_output.put_line('Last Name: '||v_lastname);
exception
when no_data_found then
dbms_output.put_line('No data found');
end;

-- conditional statements

set serveroutput on

declare
v_age number;
begin
v_age := 20;
if v_age > 18 then
dbms_output.put_line('You are eligible to vote!');
else
dbms_output.put_line('You are not eligible to vote!');
end if;
end;

declare
v_salary number;
begin
select salary into v_salary from employees where trim(first_name) = 'Mith';
if v_salary > 5000 then
dbms_output.put_line('You are not eligible for raise');
else 
dbms_output.put_line('You are eligible for raise');
end if;
exception
when TOO_MANY_ROWS then
dbms_output.put_line('Change the query');
end;

-- naming the exceptions
desc employees;

desc departments;

select * from employeeexample;

desc departmentexample;

select * from countries;

select * from locations;

update locations set country_id = 107 where location_id = 104;

alter table locations add constraint countryidfk foreign key (country_id)
references countries(country_id);

alter table locations modify country_id number(3);

delete from locations;

desc locations;

desc countries;

select salary from employees;


declare
country_not_found exception;
pragma exception_init(country_not_found, -2291);
begin
insert into locations (location_id, street_address, postal_code, city, country_id)
values ('101', 'Rander', '395005', 'Surat', 101);
exception
when country_not_found then
dbms_output.put_line('No country exists, kindly create country entry in the countries table');
end;

-- loops - starting point, termination point, step
-- loops are block of code which executes repeatedly until the condition is 
-- satisfied.

select avg(salary) from employees;

-- 4621 to 5000

update employees set salary = salary + 100;

set serveroutput on

-- repeat until
declare
v_avg_salary number;
begin
-- initialization i = 1
select avg(salary) into v_avg_salary from employees;
loop
update employees set salary = salary + 100; -- body of the loop
select avg(salary) into v_avg_salary from employees; -- step
exit WHEN v_avg_salary > 5000; -- termination point
end loop;
dbms_output.put_line('Salary updated');
end;

declare
v_avg_salary number;
begin
-- initialization i = 1
select avg(salary) into v_avg_salary from employees;
while v_avg_salary < 5000
loop
update employees set salary = salary + 100; -- body of the loop
select avg(salary) into v_avg_salary from employees; -- step
end loop;
dbms_output.put_line('Salary updated');
end;

-- %TYPE
desc employees;

declare
v_did employees.D_ID%TYPE;
begin
select D_ID into v_did from employees where trim(first_name) = 'Mith';
dbms_output.put_line('The department id is '||v_did);
end;


-- anonymous blocks - compiled and executed
-- procedures
-- named blocks - stored procedures and functions

select * from dictionary;

select * from user_procedures where object_name = 'PRC_SAYHELLO';

select * from dictionary where  TABLE_NAME like  '%SOURCE%';

SELECT * from user_source where
text like '%prc_sayhello%';

create or replace procedure prc_sayhello
as
begin
dbms_output.put_line('Hello');
end;


set serveroutput on

exec PRC_SAYHELLO;

create or replace procedure prc_sayhello(p_firstname varchar2)
as
begin
dbms_output.put_line('Hello '||p_firstname);
end;

exec PRC_SAYHELLO('Yash');

-- optional parameters / arguments
create or replace procedure prc_sayhello(p_firstname varchar2 default 'Yash')
as
begin
dbms_output.put_line('Hello '||p_firstname);
end;

exec prc_sayhello('Om');
exec prc_sayhello;

-- named parameters
create or replace procedure prc_sayhello(p_firstname varchar2, p_lastname varchar2)
as
begin
dbms_output.put_line('Hello '||p_firstname||' '||p_lastname);
end;

exec prc_sayhello('Yash', 'Shah');

-- named parameters
exec prc_sayhello(p_firstname => 'Shah', p_lastname => 'Yash');

-- calling a procedure within a procedure
begin
prc_sayhello('Sherlock','Holmes');
end;

create or replace procedure prc_callsayhello
as
begin
prc_sayhello('Jim','Moriarty');
end;

exec prc_callsayhello;

drop procedure prc_sayhello;

-- creating a procedure within a procedure
-- procedure : private
create or replace procedure prc_procinaproc
as
procedure prc_innerproc
as
begin
dbms_output.put_line('Inner procedure');
end prc_innerproc;
begin
prc_innerproc;
dbms_output.put_line('Outer procedure');
end;

exec prc_procinaproc;

-- procedure
-- functions

select * from employees;
-- empid: A Patel
-- procedure that accepts empid as a parameter
-- and returns "first character of the first name concatenate with the last name".
create or replace procedure prc_sayhello(
v_empid employees.EMP_ID%TYPE,
v_result out varchar2
)
as
v_firstname varchar2(1);
v_lastname employees.last_name%TYPE;
begin
select left(first_name, 1), last_name into v_firstname, v_lastname
from employees where emp_id = v_empid;
v_result := v_firstname||' '||v_lastname;
exception
when no_data_found then
v_result := 'No employee found for '||v_empid;
when others then
v_result := 'Exception has occured for'||v_empid;
end;


set serveroutput on

declare
v_empid employees.emp_id%TYPE;
v_result varchar2(35);
begin
v_empid := &empid;
prc_sayhello(v_empid, v_result);
dbms_output.put_line('The result is '||v_result);
end;

select * from employees;

-- procedure : DML statements, using out parameters
-- functions : you cannot use dml statements, should return a value.
select * from user_source where name like 'FX_%';

select * from user_source;

-- f(x) = x * 12
-- f(2) = 24
create or replace function fx_annual(salary employees.salary%TYPE)
return number
as
begin
return salary * 12;
end;

select fx_annual(12) from dual;

select salary, first_name, fx_annual(salary) as "Annual Salary"
from employees;

create or replace function fx_annual(v_empid employees.emp_id%TYPE)
return number
as
v_salary employees.salary%TYPE;
begin
select salary into v_salary from employees where emp_id = v_empid;
return v_salary * 12;
end;

select fx_annual(1233) from dual;

select fx_annual(77778888777) from dual;

create or replace function fx_annual(v_empid employees.emp_id%TYPE)
return number
as
v_salary employees.salary%TYPE;
begin
select salary into v_salary from employees where emp_id = v_empid;
update employees set salary = v_salary where emp_id = v_empid;
return 0;
end;

select * from employees;

-- dml operations: data manipulate
-- applications => db
-- applications : 10000 users at a time.

-- one example of function.
-- triggers

-- triggers are implicit procedures
-- they are executed when an event occurs.

-- complex validation logic: not covered through constraints
select * from employees;
-- manager manages 5 employees
-- one employee you are adding, or updating -> manager -> Mith

-- statistics: update, user, when, what
-- insert, update: derived columns store in a table

select * from dictionary where TABLE_NAME like '%TRIGGER%';

select * from USER_TRIGGERS where TABLE_NAME = 'EMPLOYEES';

ALTER TABLE EMPLOYEES DISABLE ALL TRIGGERS;

ALTER TRIGGER TR DISABLE;

ALTER TABLE EMPLOYEES ENABLE ALL TRIGGERS;

ALTER TRIGGER TR ENABLE;

SELECT * FROM USER_SOURCE WHERE name = 'TR';

CREATE OR REPLACE TRIGGER TRG_EMPLOYEES_BI_DEMO
BEFORE INSERT or update ON EMPLOYEES
BEGIN
DBMS_OUTPUT.PUT_LINE('Added or updated');
END;


DESC EMPLOYEES;

SET SERVEROUTPUT ON

INSERT INTO EMPLOYEES (EMP_ID, FIRST_NAME, LAST_NAME, HIRE_DATE)
VALUES (777888998, 'JAMES', 'BOND', SYSDATE + 4);

SELECT SYSDATE FROM DUAL;

/* MAGIC RECORDS:
NEW: INSERT, UPDATE
OLD: DELETE, UPDATE
*/
CREATE OR REPLACE TRIGGER TRG_EMPLOYEES_BI_DEMO
BEFORE INSERT ON EMPLOYEES
FOR EACH ROW
BEGIN
:NEW.HIRE_DATE := SYSDATE + 7;
:NEW.FIRST_NAME := 'I AM';
:NEW.LAST_NAME := 'SHERLOCKED';
DBMS_OUTPUT.PUT_LINE('Added HIRE_DATE value');
END;

INSERT INTO EMPLOYEES (EMP_ID, FIRST_NAME, LAST_NAME)
VALUES (777888992, 'JAMES', 'BOND');

SELECT * FROM EMPLOYEES;

update employees set salary = salary + 1000;

-- old salary: 2000: :OLD.salary
-- new salary: 1000: :NEW.salary

-- statistics
create table employees_statistics_logs_demo
(
username varchar2(45),
transaction_type varchar2(30),
transaction_date date
);

alter table employees_statistics_logs_demo add rows_affected number;

select * from employees_statistics_logs_demo;

create OR REPLACE trigger TRG_EMPLOYEES_STATISTICS_AI_DEMO
AFTER INSERT OR UPDATE OR DELETE ON EMPLOYEES
DECLARE
V_OPERATION VARCHAR2(30);
V_ROWCOUNT NUMBER;
BEGIN
IF INSERTING THEN
V_OPERATION := 'INSERT';
ELSIF UPDATING THEN
V_OPERATION := 'UPDATE';
ELSE
V_OPERATION := 'DELETE';
END IF;
V_ROWCOUNT := SQL%ROWCOUNT;
INSERT INTO EMPLOYEES_STATISTICS_LOGS_DEMO (USERNAME, TRANSACTION_TYPE, 
TRANSACTION_DATE, ROWS_AFFECTED) VALUES
(USER, V_OPERATION, SYSDATE, V_ROWCOUNT);
DBMS_OUTPUT.PUT_LINE('STATISTICS ADDED');
END;

SELECT * FROM EMPLOYEES;

UPDATE EMPLOYEES SET SALARY = SALARY + 1000;

SELECT * FROM EMPLOYEES_STATISTICS_LOGS_DEMO;

set serveroutput on

begin
update employees set salary = salary + 1000;
dbms_output.put_line('Total rows updated are : '||SQL%ROWCOUNT);
end;

SELECT USER FROM DUAL;

select * from employees;


CREATE OR REPLACE TRIGGER TRG_EMPLOYEES_BU_SALARY_DEMO
BEFORE UPDATE OF SALARY ON EMPLOYEES
FOR EACH ROW
BEGIN
dbms_output.put_line('Validating Salary...');
IF :OLD.SALARY > :NEW.SALARY THEN
raise_application_error(-20111, 'New Salary should be greater than Old Salary');
END IF;
END;

select * from employees;

update employees set last_name = 'Desai' where emp_id = 1233;

11312.996
update employees set salary = 12312 where emp_id = 1233;

alter trigger TRG_EMPLOYEES_STATISTICS_AI_DEMO disable;

update employees set last_name = 'Bond', salary = 10 where emp_id =1233;

