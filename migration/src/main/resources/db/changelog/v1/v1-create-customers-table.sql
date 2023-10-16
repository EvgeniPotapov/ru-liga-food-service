-- liquibase formatted sql
-- changeset evgenii:2

create table if not exists customers(
    id bigint not null primary key,
    phone varchar(150) not null,
    email varchar(40) not null,
    address varchar not null
    );