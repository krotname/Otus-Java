CREATE TYPE gender AS ENUM ('M', 'F');

CREATE TABLE users
(
    id              uuid PRIMARY KEY,
    login           varchar(255) NOT NULL UNIQUE,
    password        varchar(255) NOT NULL,
    salt            varchar(255) NOT NULL,
    last_name       varchar(255),
    first_name      varchar(255),
    address         varchar(255),
    email           varchar(255) NOT NULL,
    phone           CHAR(15),
    sex             gender,
    birthday        date CHECK (birthday <= current_date),
    employee        smallint     NOT NULL,
    inn             CHAR(15) NULL,
    passport_number CHAR(15) NULL,
    created_at      timestamp with time zone DEFAULT current_timestamp,
    updated_at      timestamp with time zone DEFAULT current_timestamp,
    ip_address      INET
);

CREATE TABLE characteristics
(
    id          uuid PRIMARY KEY,
    weight      varchar(255), -- вес
    height      varchar(255), -- высота
    width       varchar(255), -- ширина
    length      varchar(255), -- длина
    description TEXT,
    other       jsonb NULL
);

CREATE TABLE category
(
    id            uuid PRIMARY KEY,
    name          varchar(255) NOT NULL UNIQUE,
    description   TEXT,
    permitted_age bigint
);

CREATE TABLE product
(
    id              uuid PRIMARY KEY,
    name            varchar(255) NOT NULL UNIQUE,
    quantity        bigint       NOT NULL CHECK (quantity >= 0),
    characteristics uuid REFERENCES characteristics (id) ON DELETE CASCADE ON UPDATE CASCADE,
    price           DECIMAL(10, 2)        NOT NULL,
    photo           varchar(255),
    category        uuid REFERENCES category (id) ON DELETE CASCADE ON UPDATE CASCADE,
    measure         varchar(255) NULL, -- мера измерения
    created_at      timestamp with time zone DEFAULT current_timestamp,
    updated_at      timestamp with time zone DEFAULT current_timestamp
);

CREATE TABLE baskets
(
    id         uuid PRIMARY KEY,
    user_id    uuid REFERENCES users (id),
    created_at timestamp with time zone DEFAULT current_timestamp,
    updated_at timestamp with time zone DEFAULT current_timestamp
);

CREATE TABLE basket_items
(
    basket_id  uuid REFERENCES baskets (id) ON DELETE CASCADE ON UPDATE CASCADE,
    product_id uuid REFERENCES product (id) ON DELETE CASCADE ON UPDATE CASCADE,
    quantity   bigint CHECK (quantity >= 0),
    PRIMARY KEY (basket_id, product_id),
    created_at timestamp with time zone DEFAULT current_timestamp,
    updated_at timestamp with time zone DEFAULT current_timestamp
);

CREATE TABLE orders
(
    id          uuid PRIMARY KEY,
    user_id     uuid REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    basket      uuid REFERENCES baskets (id) ON DELETE CASCADE ON UPDATE CASCADE,
    description TEXT,
    created_at  timestamp with time zone DEFAULT current_timestamp,
    updated_at  timestamp with time zone DEFAULT current_timestamp
);

CREATE TABLE order_items
(
    basket_id  uuid REFERENCES baskets (id) ON DELETE CASCADE ON UPDATE CASCADE,
    product_id uuid REFERENCES product (id) ON DELETE CASCADE ON UPDATE CASCADE,
    quantity   bigint CHECK (quantity >= 0),
    PRIMARY KEY (basket_id, product_id),
    created_at timestamp with time zone DEFAULT current_timestamp,
    updated_at timestamp with time zone DEFAULT current_timestamp
);



CREATE TABLE manufacturer
(
    id                 uuid PRIMARY KEY,
    name               varchar(255) NOT NULL UNIQUE,
    description        TEXT,
    site_url           varchar(255) NULL,
    year_of_foundation bigint
);

CREATE TABLE goods_delivery
(
    id          uuid PRIMARY KEY,
    product_id  uuid REFERENCES product (id) ON DELETE CASCADE ON UPDATE CASCADE,
    quantity    bigint NOT NULL CHECK (quantity >= 0),
    description TEXT,
    created_at  timestamp with time zone DEFAULT current_timestamp,
    updated_at  timestamp with time zone DEFAULT current_timestamp
);

CREATE TABLE shop_info
(
    id                 uuid PRIMARY KEY,
    name               varchar(255) NOT NULL,
    description        TEXT,
    site_url           varchar(255),
    year_of_foundation bigint,
    phone              CHAR(15),
    inn                CHAR(15)  NOT NULL,
    kpp                CHAR(15)  NOT NULL
);

CREATE INDEX idx_users_email ON users (email);
CREATE INDEX idx_users_login ON users (login);
CREATE INDEX idx_product_name ON product (name);