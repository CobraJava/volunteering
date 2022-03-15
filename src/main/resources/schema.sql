CREATE TABLE TBL_EMPLOYEES
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    email      VARCHAR(250) DEFAULT NULL
);

CREATE TABLE ORDERS
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY

);

CREATE TABLE CLOTHES
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(250) NOT NULL,
    size     VARCHAR(250) NOT NULL,
    ORDER_ID BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE MEDICINE
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    ORDER_ID    BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE ARMOR_VEST
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(250) NOT NULL,
    protection VARCHAR(250) NOT NULL,
    ORDER_ID   BIGINT,
    foreign key (ORDER_ID) references ORDERS

);