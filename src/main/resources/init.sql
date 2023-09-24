--------------------------------------------------------
--  DDL for schema shop
--------------------------------------------------------
DROP SCHEMA IF EXISTS shop;
CREATE SCHEMA IF NOT EXISTS shop;
--------------------------------------------------------
--  Table shop.users
--------------------------------------------------------
DROP TABLE IF EXISTS shop.users;
CREATE TABLE IF NOT EXISTS shop.users
(
    id       INT            NOT NULL AUTO_INCREMENT,
    name     VARCHAR(45)    NOT NULL,
    surname  VARCHAR(60)    NOT NULL,
    birthday Timestamp      NOT NULL,
    balance  DECIMAL(10, 2) NOT NULL,
    email    VARCHAR(45)    NOT NULL,
    password VARCHAR(45)    NOT NULL,
    street   VARCHAR(45),
    accommodation_number VARCHAR(45),
    flat_number VARCHAR(45),
    phone_number VARCHAR(45),
    PRIMARY KEY (id),
    UNIQUE INDEX IDX_USERS_USER_ID_UNIQUE (id ASC),
    UNIQUE INDEX IDX_USERS_EMAIL_UNIQUE (email ASC),
    UNIQUE INDEX IDX_USERS_PASSWORD_UNIQUE (password ASC)
    );

--------------------------------------------------------
--  Table shop.categories
--------------------------------------------------------
DROP TABLE IF EXISTS shop.categories;
CREATE TABLE IF NOT EXISTS shop.categories
(
    id   INT         NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX IDX_CATEGORIES_CATEGORY_ID_UNIQUE (id ASC),
    UNIQUE INDEX IDX_CATEGORIES_NAME_UNIQUE (name ASC)
    );

--------------------------------------------------------
--  Table shop.products
--------------------------------------------------------
DROP TABLE IF EXISTS shop.products;
CREATE TABLE IF NOT EXISTS shop.products
(
    id          INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(90)  NOT NULL,
    description VARCHAR(3000) NOT NULL,
    price       DOUBLE       NOT NULL,
    category_id  INT          NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX IDX_PRODUCTS_ID_UNIQUE (id ASC),
    CONSTRAINT FK_PRODUCTS_CATEGORY_ID_CATEGORIES_ID
    FOREIGN KEY (category_id)
    REFERENCES shop.categories (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

--------------------------------------------------------
--  Table shop.orders
--------------------------------------------------------
DROP TABLE IF EXISTS shop.orders;
CREATE TABLE IF NOT EXISTS shop.orders
(
    id         INT         NOT NULL AUTO_INCREMENT,
    user_id     INT         NOT NULL,
    created_at Timestamp   NOT NULL,
    price      DOUBLE      NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX IDX_ORDERS_ID_UNIQUE (id ASC),
    CONSTRAINT FK_ORDERS_USER_ID_USERS_ID
    FOREIGN KEY (user_id)
    REFERENCES shop.users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );
--------------------------------------------------------
--  Table shop.order_lists
--------------------------------------------------------
DROP TABLE IF EXISTS shop.order_lists;
CREATE TABLE IF NOT EXISTS shop.order_lists
(
    order_id   INT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (order_id, product_id),
    CONSTRAINT FK_ORDERS_PRODUCTS_ORDER_ID_ORDERS_ID
    FOREIGN KEY (order_id)
    REFERENCES orders (id),
    CONSTRAINT FK_ORDERS_PRODUCTS_PRODUCT_ID_PRODUCTS_ID
    FOREIGN KEY (product_id)
    REFERENCES products (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );
--------------------------------------------------------
--  Table shop.images
--------------------------------------------------------
DROP TABLE IF EXISTS shop.images;
CREATE TABLE IF NOT EXISTS shop.images
(
    id           INT          NOT NULL AUTO_INCREMENT,
    image_path    VARCHAR(150) NOT NULL,
    primary_image INT          NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX IDX_IMAGES_ID_UNIQUE (id ASC),
    CONSTRAINT FK_IMAGES_CATEGORIES_ID_CATEGORIES_ID
    FOREIGN KEY (category_id)
    REFERENCES shop.categories (id),
    CONSTRAINT FK_IMAGES_PRODUCTS_ID_PRODUCTS_ID
    FOREIGN KEY (product_id)
    REFERENCES shop.products (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

--------------------------------------------------------
--  Table shop.statistic
--------------------------------------------------------
DROP TABLE IF EXISTS shop.statistic;
CREATE TABLE IF NOT EXISTS shop.statistic
(
    id          INT          NOT NULL AUTO_INCREMENT,
    description VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
    );