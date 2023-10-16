-- liquibase formatted sql
-- changeset evgenii:3
create table if not exists restauran_menu_items(

    id bigint not null primary key ,
    restauran_id bigint not null ,
    nameItems varchar(100) not null,
    price money not null,
    image varchar(50) not null,
    description varchar(200) not null,
    foreign key (restauran_id) references restaurant (id)
);