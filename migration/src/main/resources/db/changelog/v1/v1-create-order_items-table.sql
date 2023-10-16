-- liquibase formatted sql
-- changeset evgenii:5
create table if not exists order_items(
    id bigint not null primary key,
    order_id bigint not null ,
    restaurant_menu_item varchar(40) not null,
    price money not null  ,
    quantitu bigint not null,
    foreign key (order_id) references orders(id)
    );