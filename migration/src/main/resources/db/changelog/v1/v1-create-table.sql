create sequence if not exists couriers_seq;
create table if not exists couriers(
    id bigint not null primary key,
    phone varchar(150) not null,
    status varchar(40) not null,
    coordinates varchar not null
    );
create sequence if not exists custom_seq;
create table if not exists customers(
    id bigint not null primary key,
    phone varchar(150) not null,
    email varchar(40) not null,
    address varchar not null
    );

create sequence if not exists restor_seq;
create table if not exists restaurant(
    id bigint not null primary key,
    address varchar(150) not null,
    status varchar(40) not null
    );

create sequence if not exists restor_menu_seq;
create table if not exists restauran_menu_items(

    id bigint not null primary key ,
    restauran_id bigint not null ,
    nameItems varchar(100) not null,
    price money not null,
    image varchar(50) not null,
    description varchar(200) not null,
    foreign key (restauran_id) references restaurant (id)
);


create sequence if not exists order_seq;
create table if not exists orders(

    id bigint not null primary key,
    customer_id bigint not null ,
    restauran_id bigint not null ,
    status varchar(40) not null,
    courier_id bigint  ,
    time_stamp varchar(10) not null,
    foreign key (customer_id) references customers (id),
    foreign key (restauran_id) references restaurant (id),
    foreign key (courier_id) references couriers(id)
    );

create sequence if not exists order_item_seq;
create table if not exists order_items(
    id bigint not null primary key,
    order_id bigint not null ,
    restaurant_menu_item varchar(40) not null,
    price money not null  ,
    quantitu bigint not null,
    foreign key (order_id) references orders(id)
    );


