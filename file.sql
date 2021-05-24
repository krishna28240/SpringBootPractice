-- database and table create steps
create database productCatalog

CREATE TABLE category(id int not null primary key auto_increment, name varchar(50) not null);

create table category_attributes (attribute_id int primary key auto_increment , attribute_name varchar(200) not null, attribute_value varchar(200) not null, category_id int not null);

create table product (id int not null primary key auto_increment, product_id varchar2(300) not null  ,
product_name varchar(200) not null,category_id int not null,category_name varchar2(50) not null,
quantity_per_unit int, unit_price double, total_cost double);