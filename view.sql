//create new database in SSMS

//create tables(employees,products,sales)
Create table employees(
employeeid int not null,
name nvarchar(50) not null,
title nvarchar(100) not null,
hiredate datetime not null,
vacationhours smallint not null,
salary decimal(19,4) not null
);

Create table products(
productid int not null,
productname nvarchar(255) not null,
price decimal(19,4) not null
);

create table sales(
salesid int not null,
productid int not null,
employeeid int not null,
quantity smallint not null,
saledate datetime not null
);


//insert 5 values in each table

//create view
create view [ProductsAboveAveragePrice] as
select productname,price 
from products 
where price>(select avg(price) from products)

//print view
select * from ProductsAboveAveragePrice;