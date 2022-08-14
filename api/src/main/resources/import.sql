INSERT INTO `users` (username, password, enabled) VALUES ('Rosten', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('RostenRossAdmin', '$2a$10$Dyx/LIs5FjBKU11pg3XG7uURB49s/1jnNJoVLv5efKFVd0FOcTRFe', 1);

INSERT INTO `customers` (user_id) VALUES (1);
INSERT INTO `customers` (user_id) VALUES (2);

INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);