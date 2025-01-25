
--------Queries for pos--------

create table if not exists users(
        id serial not null primary key,
        username varchar(20) not null,
        password varchar(20) not null,
        role varchar(10) not null,
        is_active boolean default true,
        created_on date default now()
);

create table if not exists cashiers(
        id serial not null primary key,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        email varchar(70) null,
        phone varchar(15) null,
        address varchar(200) not null,
        gender varchar(1) null,
        created_on date default now()
        )

INSERT INTO cashiers (id, name, address, phone) VALUES (1, 'Umar', 'House no.1 street no.2 somewhere in Lahore', '1234567');
INSERT INTO cashiers (id, name, address, phone) VALUES (2, 'Ali', 'House no.1 street no.2 somewhere in Lahore', '1234567');
INSERT INTO cashiers (id, name, address, phone) VALUES (3, 'Ahmad', 'House no.1 street no.2 somewhere in Lahore', '1234567');
INSERT INTO cashiers (id, name, address, phone) VALUES (4, 'Imran', 'House no.1 street no.2 somewhere in Lahore', '1234567');
INSERT INTO cashiers (id, name, address, phone) VALUES (5, 'Ayesha', 'House no.1 street no.2 somewhere in Lahore', '1234567');


create table if not exists managers(
        id serial not null primary key,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        email varchar(70) null,
        phone varchar(15) null,
        address varchar(200) not null,
        gender varchar(1) null,
        created_on date default now()
        );

create table if not exists admins(
        id serial not null primary key,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        phone varchar(15) null,
        created_on date default now()
        );

create table if not exists items(
        id serial not null primary key,
        product_id serial not null,
        order_id serial not null,
        name varchar(50) not null,
        price decimal not null,
        discount decimal null,
        discounted_price decimal null,
        promotion boolean null default false,
        quantity integer null
        )

create table if not exists orders(
        id serial not null primary key,
        cashier_id serial not null,
        transaction_id serial not null,
        item_id varchar(50) not null,
        total_amount decimal not null,
        checkout boolean null,
        discounted_price decimal null,
        promotion boolean null default false,
        quantity integer null,
        created_on date default now()
        )

create table if not exists products(
        id serial not null primary key,
        supplier_id serial not null,
        type  varchar(20) null,
        model varchar(220) null,
        name varchar(30) not null,
        price decimal not null,
        description text null,
        manufacturer varchar(30) null,
        status varchar(20) null,
        created_on date default now()
        )