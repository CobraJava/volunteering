INSERT INTO ORDERS (id) VALUES
(1),
(2),
(3);

INSERT INTO CLOTHES (id, name, size, order_id) VALUES
(1, 'T-shirt', 'L', 1),
(2, 'Jacket', 'm', 1),
(3, 'Hoodie', 's', 2),
(4,'dddddd', 'L', 2),
(5,'eeeeee', 'L', 3),
(6,'fffffff', 'L', NULL),
(7,'gggggg', 'L', NULL);

INSERT INTO ARMOR_VEST (id, name, protection, order_id) VALUES
(1,'Model55', '5', 3),
(2,'Model56', '5', 3),
(3,'model57', '5', 2),
(4,'Model58', '5', 2),
(5,'Model75', '7', 1),
(6,'Model76', '7', NULL),
(7,'Model77', '7', NULL);

INSERT INTO MEDICINE (id, name, description, order_id) VALUES
(1,'Paracetamol', 'Used to treat aches and pain. It can also be used to reduce a high temperature.', 2),
(2,'Farmacetron', 'Used to treat colds an flu', 1),
(3,'Fastum gel', 'Anti-inflammatory and analgesic ointments', 1),
(4,'Nurofen', 'Analgesics', 3),
(5,'Pantenol', 'Use in case of cut injuries', 3),
(6,'Valocardine', 'Soothing and heart drugs', NULL),
(7,'Ototon', 'Anti-inflammatory ear drops', NULL);

