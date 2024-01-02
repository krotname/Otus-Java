CREATE TABLE clients
(
    id     BIGSERIAL PRIMARY KEY,
    name   VARCHAR(255),
    phones VARCHAR(255)
);

CREATE TABLE addresses
(
    id        BIGSERIAL PRIMARY KEY,
    CLIENT_ID BIGINT NOT NULL REFERENCES CLIENTS (id),
    street    VARCHAR(255)
);

CREATE TABLE phones
(
    id        BIGSERIAL PRIMARY KEY,
    client_id BIGINT NOT NULL REFERENCES CLIENTS (id),
    number    VARCHAR(255)
);


insert into clients (name)
values ('Ivan');
insert into addresses (client_id, street)
values (1, 'Lenina');
insert into clients (name)
values ('Petr');
insert into addresses (client_id, street)
values (2, 'Plato');
