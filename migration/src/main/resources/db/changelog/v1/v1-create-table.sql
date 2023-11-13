create sequence if not exists couriers_seq;
create table if not exists couriers(
    id bigint not null primary key,
    phone varchar(150) not null,
    status varchar(40) not null,
    coordinates varchar (100) not null
    );
create sequence if not exists custom_seq;
create table if not exists customers(
    id bigint not null primary key,
    phone varchar(40) not null,
    email varchar(40) ,
    address varchar not null
    );

create sequence if not exists restor_seq;
create table if not exists restaurant(
    id uuid not null primary key,
    address varchar(150) not null,
    status varchar(40) not null,
    name_restaurant varchar(40) not null UNIQUE
    );

create sequence if not exists restor_menu_seq;
create table if not exists restauran_menu_items(

    id uuid not null primary key ,
    restauran_id uuid not null ,
    name_items varchar(100) not null,
    price money not null,
    image varchar(50) ,
    description varchar(200) ,
    foreign key (restauran_id) references restaurant (id)
);


create sequence if not exists order_seq;
create table if not exists orders(

    id uuid not null primary key,
    customer_id bigint not null ,
    restauran_id bigint not null ,
    status varchar(40) not null,
    courier_id bigint  ,
    time_stamp TIMESTAMP not null,
    foreign key (customer_id) references customers (id),
    foreign key (restauran_id) references restaurant (id),
    foreign key (courier_id) references couriers(id)
    );

create sequence if not exists order_item_seq;
create table if not exists orders_items(
    id uuid not null primary key,
    order_id uuid not null ,
    restaurant_menu_item bigint not null,
    price numeric not null  ,
    quantity bigint not null,
    foreign key (order_id) references orders(id)
    );


