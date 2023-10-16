-- liquibase formatted sql
-- changeset evgenii:4
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

