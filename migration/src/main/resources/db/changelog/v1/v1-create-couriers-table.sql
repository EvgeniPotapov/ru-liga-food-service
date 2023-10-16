-- liquibase formatted sql
-- changeset evgenii:1
create table if not exists couriers(
    id bigint not null primary key,
    phone varchar(150) not null,
    status varchar(40) not null,
    coordinates varchar not null
    );