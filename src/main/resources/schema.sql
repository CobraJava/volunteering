CREATE TABLE ORDERS
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE JACKET
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(20) NOT NULL,
    size     VARCHAR(10) NOT NULL,
    ORDER_ID BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE SHOES
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(20) NOT NULL,
    size_uk  INTEGER     NOT NULL,
    ORDER_ID BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE PARACETAMOL
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(20)  NOT NULL,
    prescription VARCHAR(250) NOT NULL,
    description  VARCHAR(250) NOT NULL,
    ORDER_ID     BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE FARMACETRON
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(20)  NOT NULL,
    prescription VARCHAR(250) NOT NULL,
    dosage       VARCHAR(250) NOT NULL,
    ORDER_ID     BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE ARMOR_VEST
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(20) NOT NULL,
    protection INTEGER     NOT NULL,
    ORDER_ID   BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE USER
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    name               VARCHAR(20) NOT NULL,
    age                INTEGER     NOT NULL,
    role               VARCHAR(20) NOT NULL,
    country            VARCHAR(20) NOT NULL,
    experience         VARCHAR(20) NOT NULL,
    salary_expectation INTEGER     NOT NULL,
    english_level      VARCHAR(20) NOT NULL,
    career             VARCHAR(300) NOT NULL
);
