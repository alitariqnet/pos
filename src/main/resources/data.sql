
--------Queries for pos--------

create table if not exists users(
        id serial not null primary key,
        username varchar(20) not null,
        password varchar(20) not null,
        role varchar(15) not null,
        is_active boolean default true,
        created_on timestamp default now()
);

create table if not exists cashiers(
        id serial not null primary key,
        user_id serial REFERENCES users (id),
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        email varchar(70) null,
        phone varchar(15) null,
        address varchar(200) not null,
        gender varchar(1) null,
        created_on timestamp default now()
        );

INSERT INTO cashiers (name, address, phone) VALUES ('Umar', 'House no.1 street no.2 somewhere in Lahore', '1234567');
INSERT INTO cashiers (name, address, phone) VALUES ('Ali', 'House no.1 street no.2 somewhere in Lahore', '1234567');
INSERT INTO cashiers (name, address, phone) VALUES ('Ahmad', 'House no.1 street no.2 somewhere in Lahore', '1234567');
INSERT INTO cashiers (name, address, phone) VALUES ('Imran', 'House no.1 street no.2 somewhere in Lahore', '1234567');
INSERT INTO cashiers (name, address, phone) VALUES ('Ayesha', 'House no.1 street no.2 somewhere in Lahore', '1234567');


create table if not exists managers(
        id serial not null primary key,
        user_id serial REFERENCES users (id),
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        email varchar(70) null,
        phone varchar(15) null,
        address varchar(200) not null,
        gender varchar(1) null,
        created_on timestamp default now()
        );

create table if not exists admins(
        id serial not null primary key,
        user_id serial REFERENCES users (id),
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        phone varchar(15) null,
        created_on timestamp default now()
        );

create table if not exists transactions(
        id serial not null primary key,
        cashier_id serial REFERENCES cashiers (id),
        sub_total decimal not null,
        net_payable decimal not null,
        service_fee decimal null,
        received_amount decimal null,
        change_due decimal null,
        created_on timestamp default now()
        );

create table if not exists orders(
        id serial not null primary key,
        cashier_id serial REFERENCES cashiers (id),
        transaction_id serial REFERENCES transactions (id),
        quantity smallint null,
        total_amount decimal not null,
        checkout boolean null,
        created_on timestamp default now()
        );

create table items(
        id serial not null primary key,
        product_id serial REFERENCES products (id),
        order_id serial REFERENCES orders (id),
        serial_no smallint null,
        name varchar(50) not null,
        unit_price decimal not null,
        total_price decimal not null,
        -- smallint   2 bytes   small-range integer   -32768 to +32767
        discount smallint null,
        discounted_price decimal null,
        promotion boolean null default false,
        quantity integer null
        );

create table if not exists products(
        id serial not null primary key,
        supplier_id serial REFERENCES suppliers (id),
        type  varchar(20) null,
        model varchar(220) null,
        name varchar(30) not null,
        price decimal not null,
        description text null,
        manufacturer varchar(30) null,
        status varchar(20) null,
        created_on timestamp default now()
        );

create table suppliers(
        id serial not null primary key,
        name varchar(50) not null,
        address text not null,
        phone varchar(15) null,
        created_on timestamp default now()
        );