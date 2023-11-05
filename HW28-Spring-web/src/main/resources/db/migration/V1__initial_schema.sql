CREATE TABLE clients
(
    id     BIGINT NOT NULL PRIMARY KEY,
    name   VARCHAR(255),
    phones VARCHAR(255)
);

CREATE TABLE addresses
(
    id        BIGINT NOT NULL PRIMARY KEY,
    CLIENT_ID BIGINT NOT NULL REFERENCES CLIENTS (id),
    street    VARCHAR(255)
);

CREATE TABLE phones
(
    id        BIGINT NOT NULL PRIMARY KEY,
    client_id BIGINT NOT NULL REFERENCES CLIENTS (id),
    number    VARCHAR(255)
);


insert into clients (id, name)
values (1, 'Ivan');
insert into addresses (id, client_id, street)
values (1, 1, 'Lenina');
insert into clients (id, name)
values (2, 'IvanIvan');
insert into addresses (id, client_id, street)
values (2, 2, 'LeninaIvan');
