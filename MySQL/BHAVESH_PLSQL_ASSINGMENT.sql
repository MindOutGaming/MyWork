
pl/sql
--question 1:
--1. Write a PL/SQL program to calculate the area of the circle. Take pi value as 3.14
declare
my_value number;
result number;
begin
my_value := &redius;
result := (my_value*my_value)*3.14;
dbms_output.put_line('Area of Circle for '||my_value||' is:- '||result);
end;

--question 2:
--2. Write a PL/SQL block
--● That includes declarations for the following variables:
--○ A VARCHAR2 data type that can contain the string ‘Introduction to Oracle
--PL/SQL’
--○ A NUMBER that can be assigned 987654.55, but not 987654.567 or
--9876543.55
--○ A CONSTANT (you choose the correct data type) that is auto-initialized to
--the value ‘603D’
--○ A BOOLEAN
--○ A DATE data type auto initialized to one week from today
--● In the body of the PL/SQL block, put a DBMS_OUTPUT.PUT_LINE message for
--each of the variables that received an auto initialization value.
--● In a comment at the bottom of the PL/SQL block, state the value of your
--NUMBER data type.

declare
u_str varchar2(50):='Introduction to Oracle PL/SQL';
u_num number(8,2):=987654.55;
u_constVariable constant varchar2(10):='603D';
u_bool boolean;
u_Date date :=sysdate+7;
begin
dbms_output.put_line('String is:- '||u_str);
dbms_output.put_line('Number is:- '||u_num);
dbms_output.put_line('constant is:- '||u_constVariable);
dbms_output.put_line('Boolean is:- '||case when u_bool then 'TRUE' else 'FALSE' end);
dbms_output.put_line('Date is:- '||u_Date);
end;

--question 3:
--3. Execute the following two PL/SQL blocks, and explain why they produce different output
--for the same value of the variable v_num . Remember to issue the SET
--SERVEROUTPUT ON command before running this script.

-- Block 1
DECLARE
v_num NUMBER := NULL;
BEGIN
IF v_num > 0 THEN
DBMS_OUTPUT.PUT_LINE ('v_num is greater than 0');
ELSE
DBMS_OUTPUT.PUT_LINE ('v_num is not greater than 0');
END IF;
END;
-- Block 2
DECLARE
v_num NUMBER := NULL;
BEGIN
IF v_num > 0 THEN
DBMS_OUTPUT.PUT_LINE ('v_num is greater than 0');
END IF;
IF NOT (v_num > 0) THEN
DBMS_OUTPUT.PUT_LINE ('v_num is not greater than 0');
END IF;
END;

--Ans:= because null values is not true and false, it is null so if condition is not saticified

--question 4:
-- 4. Write a procedure with no parameters. The procedure should say whether the current
-- day is a weekend or weekday. Additionally, it should tell you the user’s name and the
-- current time. It also should specify how many valid and invalid procedures are in the
-- database.

create OR REPLACE procedure my_log_procedure
as
current_day char(15);
user_name varchar2(20);
current_time char(15);
valid_procedures number;
invalid_procedures number;
BEGIN
select user,TO_CHAR(SYSDATE,'HH12:MI:SS'),TO_CHAR(SYSDATE,'DAY')  into user_name,current_time,current_day FROM dual;
SELECT COUNT(*) into valid_procedures FROM USER_OBJECTS WHERE OBJECT_TYPE='PROCEDURE' AND STATUS='VALID';
SELECT COUNT(*) into invalid_procedures FROM USER_OBJECTS WHERE OBJECT_TYPE='PROCEDURE' AND STATUS='INVALID';
IF (current_day = 'SUNDAY' OR current_day = 'SATURDAY') THEN
dbms_output.put_line('today is weekend');
ELSE
dbms_output.put_line('TODAY IS WEEKDAY');
END IF;
dbms_output.put_line('CURRENT USER IS:- ' ||user_name);
dbms_output.put_line('CURRENT TIME IS:- ' ||current_time);
dbms_output.put_line('TOTAL VALID PROCEDURE IS:- ' ||valid_procedures);
dbms_output.put_line('TOTAL INVALID PROCEDURE IS:- ' ||invalid_procedures);
end;

--question 5:

-- 5. Write a procedure that takes in a zip code, city, and state and inserts the values into the
-- zip code table. It should check to see if the zip code is already in the database. If it is, an
-- exception should be raised, and an error message should be displayed. Write an
-- anonymous block that uses the procedure and inserts your zip code.
create table zip_code_tab(zip_code number(3),city varchar2(30),state varchar2(30));
insert into zip_code_tab values(1,'surat','gujarat');
 
 create OR replace procedure insert_zip_tab(z_code zip_code_tab.zip_code%TYPE,z_city zip_code_tab.city%TYPE, z_state zip_code_tab.state%TYPE)
 as
 exist_code number;
 present_exception exception;
pragma exception_init(present_exception,-2291);
 begin
  select zip_code into exist_code from zip_code_tab where zip_code=z_code;
  if(exist_code=z_code) THEN
  RAISE present_exception;
  end if;
exception 
WHEN present_exception THEN
dbms_output.put_line(z_code||' code is allready in the database');
 WHEN NO_DATA_FOUND THEN
insert into zip_code_tab(zip_code,city,state)values(z_code,z_city,z_state);
dbms_output.put_line('inserted done!');
 end;

--question 6:

-- 6. Write a stored function called zip_does_not_exist that takes in a zipcode.zip%TYPE and
-- returns a Boolean. The function will return TRUE if the zip code passed into it does not
-- exist. It will return a FALSE if the zip code does exist.

 create or replace function zip_does_not_exist(zipcode zip_code_tab.zip_code%TYPE  default '0')
 return boolean
 as
 num number;
 begin
 select zip_code into num FROM zip_code_tab where zip_code=zipcode;
if(num=zipcode) THEN
return TRUE;
ELSE
return FALSE;
end if;
exception  
when  NO_DATA_FOUND then
return FALSE;
 end;

declare
v_result boolean;
begin
v_result:=zip_does_not_exist();
dbms_output.put_line(case when v_result then 'TRUE' else 'FALSE' end);
end;


--question 7:
-- 7. Ensure no changes can be made to the EMPLOYEES table before 6am and after 10pm
-- in a day
create table employees(emp_id number,emp_name varchar2(30));
insert into employees values(1,'bhavesh');

create or replace trigger restrict_employees_changes
before insert or update or delete  on EMPLOYEES
for each row
declare
current_hour number;
begin
select TO_NUMBER(TO_CHAR(SYSDATE,'HH24')) into current_hour FROM DUAL;
IF(current_hour < 6 OR current_hour >= 22) THEN
RAISE_APPLICATION_ERROR(-20001,'change to employees table not allowed between 6am and 10am');
END IF;
end;

