/*create users*/
INSERT INTO `users` (username, password, enabled) VALUES ('RostenRoss', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('RostenRossAdmin', '$2a$10$Dyx/LIs5FjBKU11pg3XG7uURB49s/1jnNJoVLv5efKFVd0FOcTRFe', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('EliPas', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('MaCristina', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('NestorCos', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('PiliBe', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);

/*create customers*/
INSERT INTO `customers` (user_id, name, lastname, create_at, email) VALUES (1,'Rosten', 'Ross', '2017-08-01','rosten_ross@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (2,'Rosten', 'Ross', '2017-08-01','rosten_ross@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (3,'Elias','Pascuet', '2017-08-01','elias_pascuet@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (4,'Maria Cristina','Roma', '2017-08-01','marica_roma@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (5,'Nestor Matias','Costantini', '2017-08-01','nestor_costantini@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (6,'Pilar','Benitez', '2017-08-01','pilar_benitez@gmail.com');

/*create roles*/
INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

/*create  useres_roles (only users) */
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (6, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (3, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (4, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (5, 1);

/*create  useres_roles (only admin) */
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);

/*create posts*/

INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Muy rico todo.', '2017-08-01',1);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Excelente atencion.',  '2017-08-01',3)
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Me encanto la musica y la comida.',  '2017-08-01',4);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Lo lindo es la variedad en el menu Vegano.',  '2017-08-01',5);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Las pastas fueron lo mejor.',  '2017-08-01',6);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Viva la comida mexicana.', '2017-08-01',1);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('El servicio genial.',  '2017-08-01',4);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Las bebidas muy sabrosas.',  '2017-08-01',6);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('No hay mejor lugar', '2017-08-01',1);


/* INSERT RESTAURANT TABLES*/

INSERT INTO `tables` (number) VALUES (1);
INSERT INTO `tables` (number) VALUES (2);
INSERT INTO `tables` (number) VALUES (3);
INSERT INTO `tables` (number) VALUES (4);
INSERT INTO `tables` (number) VALUES (5);
INSERT INTO `tables` (number) VALUES (6);
INSERT INTO `tables` (number) VALUES (7);
INSERT INTO `tables` (number) VALUES (8);
INSERT INTO `tables` (number) VALUES (9);
INSERT INTO `tables` (number) VALUES (10);
INSERT INTO `tables` (number) VALUES (11);
INSERT INTO `tables` (number) VALUES (12);
INSERT INTO `tables` (number) VALUES (13);
INSERT INTO `tables` (number) VALUES (14);
INSERT INTO `tables` (number) VALUES (15);
INSERT INTO `tables` (number) VALUES (16);
INSERT INTO `tables` (number) VALUES (17);
INSERT INTO `tables` (number) VALUES (18);
INSERT INTO `tables` (number) VALUES (19);





/*INSERT RESERVATIONS*/


INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (1, 1, CURRENT_TIMESTAMP, '2022-09-25', 0, 1, 0);
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (2, 1, CURRENT_TIMESTAMP, '2022-09-26', 1, 1, 0);

INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (2, 2, CURRENT_TIMESTAMP, '2022-09-25', 1, 0, 0);
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (1, 2, CURRENT_TIMESTAMP, '2022-09-26', 0, 0, 0);

INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (6, 3, CURRENT_TIMESTAMp, '2022-09-25', 0, 1, 0);
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (5, 3, CURRENT_TIMESTAMP, '2022-09-27', 1, 0, 0);

INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (5, 4, CURRENT_TIMESTAMP, '2022-09-29', 0, 1, 0);
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (6, 4, CURRENT_TIMESTAMP, '2022-09-29', 1, 0, 0);

INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (5, 4, CURRENT_TIMESTAMP, '2022-09-27', 1, 1, 0);
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (6, 4, CURRENT_TIMESTAMP, '2022-09-27', 1, 1, 0);

INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (1, 1, CURRENT_TIMESTAMP, '2022-09-30', 1, 1, 0);
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (2, 1, CURRENT_TIMESTAMP, '2022-09-30', 1, 1, 0);

INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (19, 4, CURRENT_TIMESTAMP, '2022-09-25', 0, 1, 0);
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date, is_tea, hour_reservation, disabled) VALUES (30, 3, CURRENT_TIMESTAMP, '2022-09-26', 1, 1, 0);

/*INSERT MENU_TYPE*/

INSERT INTO `menu_types` (type) VALUES ('celiaco');
INSERT INTO `menu_types` (type) VALUES ('vegano');
INSERT INTO `menu_types` (type) VALUES ('vegetariano');
INSERT INTO `menu_types` (type) VALUES ('normal');

/*INSERT MENU*/

INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Camarones Jumbo', 300, 1, 4);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Pollo a la Parmesana', 300, 1, 4);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Linguini con Camarones', 300, 1, 4);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Spaguetti de la Casa', 300, 1, 4);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Pastel de Carne', 300, 1, 4);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Solomillo con Salsa Verde', 300, 1, 4);

INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Pizza Keto con Harina de Coco', 300, 1, 1);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('NaturGreen', 300, 1, 1);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Ensalada de Col Rizada Kale con Garbanzos Tostados', 300, 1, 1);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Nocchis con Boloñesa de Soja', 300, 1, 1);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Fideos Soba con Salsa de Soja', 300, 1, 1);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Jengibre Fresco', 300, 1, 1);

INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('tzatziki griego', 300, 1, 2);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Farinata genovesa o fainá', 300, 1, 2);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('tostadas de boniato', 300, 1, 2);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Hummus', 300, 1, 2);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Pan de queso minero brasileño', 300, 1, 2);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Mini Pizzas de Berenjena', 300, 1, 2);

INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Ensalada de Soja con Acelga', 300, 1, 3);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Ensalada Fin de Otoño con Amaranto', 300, 1, 3);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Ensalada Mixta con Lentejas', 300, 1, 3);
INSERT INTO `menus` (name, price, is_enabled, menu_type_id) VALUES ('Ensalada de Alubias Rojas con Guacamole', 300, 1, 3);

/* INSERT ORDERS */

INSERT INTO `orders` (customer_id, is_delivered, state, create_at) VALUES (1, 0, 0, CURRENT_TIMESTAMP);
INSERT INTO `orders` (customer_id, is_delivered, state, create_at) VALUES (2, 0, 0, CURRENT_TIMESTAMP);
INSERT INTO `orders` (customer_id, is_delivered, state, create_at) VALUES (3, 0, 0, CURRENT_TIMESTAMP);
INSERT INTO `orders` (customer_id, is_delivered, state, create_at) VALUES (4, 0, 0, CURRENT_TIMESTAMP);
INSERT INTO `orders` (customer_id, is_delivered, state, create_at) VALUES (5, 0, 0, CURRENT_TIMESTAMP);
INSERT INTO `orders` (customer_id, is_delivered, state, create_at) VALUES (6, 0, 0, CURRENT_TIMESTAMP);

/*INSERT ORDERS DETAILS*/

INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (1, 1, 1);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (2, 1, 4);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (3, 1, 9);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (4, 1, 10);

INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (2, 2, 2);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (3, 2, 4);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (4, 2, 9);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (1, 2, 6);

INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (5, 3, 13);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (2, 3, 1);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (1, 3, 2);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (1, 3, 14);

INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (1, 4, 2);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (2, 4, 5);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (5, 4, 2);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (2, 4, 7);

INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (3, 5, 5);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (3, 5, 6);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (1, 5, 10);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (2, 5, 11);

INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (1, 6, 12);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (5, 6, 13);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (2, 6, 14);
INSERT INTO `orders_detail` (quantity, order_id, menu_id) VALUES (3, 6, 15);
