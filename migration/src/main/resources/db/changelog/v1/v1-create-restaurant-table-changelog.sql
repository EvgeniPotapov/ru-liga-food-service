-- liquibase formatted sql
-- changeset evgenii:1
create table restauranty(
    id bigint not null primary key,
    address varchar(150) not null,
    status varchar(40) not null
    );