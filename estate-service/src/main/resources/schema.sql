-- Customer
create table Customer (
    id int auto_increment primary key,
    name varchar(255) not null,
    date_of_birth varchar(255) not null,
    mobile varchar(255) not null,
    created_date timestamp not null,
    updated_date timestamp not null
);

-- Items
create table Items (
    id int auto_increment primary key,
    item_name varchar(255) not null,
    price int not null,
    trade_type varchar(255) not null,
    trade_status varchar(255) not null,
    house_type varchar(255) not null,
    residence_period varchar(255) not null,
    option varchar(255) not null,
    created_date timestamp not null,
    updated_date timestamp not null
);

-- AffiliateCustomerManagement
create table AFFILIATE_CUSTOMER_MANAGEMENT (
    id int auto_increment primary key,
    progress_step varchar(255) not null,
    customer_id int not null,
    item_id int not null,
    created_date timestamp not null,
    updated_date timestamp not null,
    foreign key (customer_id) references Customer(id),
    foreign key (item_id) references Items(id)
);

