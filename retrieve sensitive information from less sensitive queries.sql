//create new database in SSMS

//create new employee table
Create table employee(
empid int,
empname char(20),
empgender char(20),
empsalary int
);

//insert 5 rows by using edit top 200 rows

//select query1
SELECT empname,empgender,
case empgender
when 'male' then 'handsome'
when 'female' then 'beautiful'
end as 'asdf'
from dbo.employee

//select query2
SELECT empname,empsalary,
case
when empname like 'd%' then
case
when empsalary>=15000 then 'A'
end
when empname like 'e%' then
case
when empsalary>=12000 then 'B'
end
else 'C'
end as "Grade"
from dbo.employee


