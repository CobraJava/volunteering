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
    size_uk     INTEGER NOT NULL,
    ORDER_ID BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE PARACETAMOL
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(20) NOT NULL,
    prescription VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    ORDER_ID    BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE FARMACETRON
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(20) NOT NULL,
    prescription VARCHAR(250) NOT NULL,
    dosage VARCHAR(250) NOT NULL,
    ORDER_ID    BIGINT,
    foreign key (ORDER_ID) references ORDERS

);

CREATE TABLE ARMOR_VEST
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(20) NOT NULL,
    protection INTEGER NOT NULL,
    ORDER_ID   BIGINT,
    foreign key (ORDER_ID) references ORDERS

);
