-- liquibase formatted sql
-- changeset evgenii:6
create table if not exists restaurant(
    id bigint not null primary key,
    address varchar(150) not null,
    status varchar(40) not null
    );



