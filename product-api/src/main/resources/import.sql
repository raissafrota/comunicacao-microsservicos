INSERT INTO CATEGORY (id, description) VALUES (1000, 'Comic Books');
INSERT INTO CATEGORY (id, description) VALUES (1001, 'Movies');
INSERT INTO CATEGORY (id, description) VALUES (1002, 'Books');

INSERT INTO SUPPLIER (id, name) VALUES (1000, 'Panini Comics');
INSERT INTO SUPPLIER (id, name) VALUES (1001, 'Amazon');

INSERT INTO PRODUCT (id, name, supplier_cod, category_cod, quantity_available, created_at) VALUES (1001, 'Crise nas Infinitas Terras', 1000, 1000, 10, CURRENT_TIMESTAMP);
INSERT INTO PRODUCT (id, name, supplier_cod, category_cod, quantity_available, created_at) VALUES (1002, 'Interestelar', 1001, 1001, 5, CURRENT_TIMESTAMP);
INSERT INTO PRODUCT (id, name, supplier_cod, category_cod, quantity_available, created_at) VALUES (1003, 'Harry Potter E A Pedra Filosofal', 1001, 1002, 3, CURRENT_TIMESTAMP);