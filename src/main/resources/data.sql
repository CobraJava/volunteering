INSERT INTO ORDERS (id) VALUES
(1),
(2),
(3);

INSERT INTO JACKET (id, name, size, order_id) VALUES
(1, 'Jacket', 'L', 1),
(2, 'Jacket', 'XL', 1),
(3, 'Hoodie', 'S', 2),
(4,'Coat', 'M', 2),
(5,'Zip hoodie', 'XL', 3),
(6,'Parka', 'S', NULL),
(7,'Parka', 'M', NULL);

INSERT INTO SHOES (id, name, size_uk, order_id) VALUES
(1, 'Diadora', 43, 1),
(2, 'Nike', 42, 1),
(3, 'Puma', 40, 2),
(4,'Scatchers', 35, 2),
(5,'NoName', 40, 3),
(6,'Adidas', 37, NULL),
(7,'NewBalance', 39, NULL);

INSERT INTO ARMOR_VEST (id, name, protection, order_id) VALUES
(1,'Model55', '5', 3),
(2,'Model56', '5', 3),
(3,'model57', '5', 2),
(4,'Model58', '5', 2),
(5,'Model75', '7', 1),
(6,'Model76', '7', NULL),
(7,'Model77', '7', NULL);

INSERT INTO PARACETAMOL (id, name, prescription, description, order_id) VALUES
(1,'Paracetamol', 'Used to treat aches and pain. It can also be used to reduce a high temperature.', 'Any desc', 2),
(2,'Paracetamol', 'Used to treat aches and pain. It can also be used to reduce a high temperature.', 'Any desc', 3),
(3,'Paracetamol', 'Used to treat aches and pain. It can also be used to reduce a high temperature.', 'Any desc', 1),
(4,'Paracetamol', 'Used to treat aches and pain. It can also be used to reduce a high temperature.', 'Any desc', NULL);



INSERT INTO FARMACETRON (id, name, prescription, dosage, order_id) VALUES
(1,'Farmacetron', 'Used to treat colds an flu', 'Any dosage', 1),
(2,'Farmacetron', 'Used to treat colds an flu', 'Any dosage', 2),
(3,'Farmacetron', 'Used to treat colds an flu', 'Any dosage', 3),
(4,'Farmacetron', 'Used to treat colds an flu', 'Any dosage', NULL);
