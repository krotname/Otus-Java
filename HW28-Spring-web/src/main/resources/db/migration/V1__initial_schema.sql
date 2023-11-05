create sequence clients_SEQ start with 1 increment by 1;
create sequence addresses_SEQ start with 1 increment by 1;
create sequence phones_SEQ start with 1 increment by 1;

create table CLIENTS
(
    id         int not null primary key,
    name       varchar(255),
    phones       varchar(255)
);

create table ADDRESSES
(
    client_id bigint not null primary key,
    clients_key bigint,
    clients bigint,
    street    varchar(255)
);

create table PHONES
(
    id varchar not null primary key,
    client_id int not null references clients(id),
    clients_key varchar,
    clients varchar,
    number    varchar(255)
);

insert into addresses (client_id, street)
values (1, 'Lenina');
insert into clients (id, name)
values (1, 'Ivan');
insert into addresses (client_id, street)
values (2, 'LeninaIvan');
insert into clients (id, name)
values (2, 'IvanIvan');