BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (user_id, username, password_hash, role, email) VALUES (default, 'testuser1', 12345, 'ROLE_USER', 'test1@test.com');
INSERT INTO users (user_id, username, password_hash, role, email) VALUES (default, 'testuser2', 12345, 'ROLE_USER', 'test2@test.com');
INSERT INTO users (user_id, username, password_hash, role, email) VALUES (default, 'testuser3', 12345, 'ROLE_USER', 'test3@test.com');
INSERT INTO users (user_id,username,password_hash,role) VALUES (default,'Aileen','$2a$10$dabfqo0hsNfAWplZU.bTeO2QMnoWL257HRuOXSceZW6LXeBqSopry','ROLE_USER');
INSERT INTO users (user_id,username,password_hash,role) VALUES (default,'Rowan','$2a$10$vwBfq7hYx/gTufIzoIt/9eR2KCCXMtp7d0Sps8tfa7u2C0ay/QoP.','ROLE_USER');
INSERT INTO users (user_id,username,password_hash,role) VALUES (default,'Diane','$2a$10$aYzD2pr9e2gavvr5.giDG.gNoprP4T5Msaf.k8B9iYdTWnD.B9NRW','ROLE_USER');


INSERT INTO shopping_group (group_id, group_name, invitation_code) VALUES (default, 'test group 1', 83472);
INSERT INTO shopping_group (group_id, group_name, invitation_code) VALUES (default, 'test group 2', 23928);
INSERT INTO shopping_group (group_id, group_name, invitation_code) VALUES (default, 'test group 3', 13232);
INSERT INTO shopping_group (group_id, group_name, invitation_code) VALUES (default, 'Christmas 2022', 83292);
Insert into shopping_group (group_id, group_name, invitation_code) values (default, 'Home', 87302);

INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 1, 1, default);
INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 2, 1, default);
INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 3, 2, default);
INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 1, 2, default);
INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 2, 3, default);
INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 3, 3, default);
INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 4, 6, default);
INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 5, 6, default);
INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 4, 7, default);
INSERT INTO shopping_group_users (shopping_group_users_id, group_id, user_id, date_joined) VALUES(default, 4, 8, default);


INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(1, 'list1', 1, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(2, 'list2', 1, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(3, 'list3', 2, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(4, 'list4', 2, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(5, 'list5', 3, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(6, 'Groceries', 4, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(7, 'From Chicago', 4, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(8, 'Santa', 4, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(9, 'Costco', 5, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(10, 'Target', 5, 'false', null, 'false');


INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (1, 1, 3, 'item1', 2, 'misc', default, 'false', '2022-12-08 12:45:24.914091', 2);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (2, 1, 4, 'item2', 2, 'misc', default, 'false', '2022-12-06 12:45:24.914091', 2);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (3, 1, 4, 'item3', 2, 'misc', default, 'false', '2022-12-07 12:45:24.914091', 3);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (4, 1, 3, 'item4', 2, 'misc', default, 'false', '2022-12-08 10:45:24.914091', 3);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (5, 2, 2, 'item5', 2, 'misc', default, 'false', '2022-12-08 12:45:24.914091', 4);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (6, 2, 3, 'item6', 2, 'misc', default, 'false', '2022-12-08 11:45:24.914091', 4);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (7, 6, 6, 'Eggs', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (8, 6, 6, 'Milk', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (9, 6, 6, 'Bread', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (10, 6, 6, 'Avocados', 6, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (11, 6, 6, 'Tortilla Chips', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (12, 6, 6, 'Potatoes', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (13, 6, 6, 'Chicken', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (14, 6, 6, 'Apples', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (15, 6, 6, 'Oranges', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (16, 6, 6, 'Spinach', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (17, 6, 6, 'Tomatoes', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (18, 6, 6, 'Onions', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (19, 6, 6, 'Ice Cream', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (30, 6, 6, 'Chicken Nuggets', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (31, 6, 6, 'Go-gurt', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);

INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (20, 7, 6, 'Vinho Verde', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (21, 7, 6, 'Giordanos', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (22, 7, 8, 'Tree Topper', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (23, 7, 8, 'Photo Album', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);

INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (24, 8, 7, 'Food Toys', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (25, 8, 7, 'Play Kitchen', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (26, 8, 7, 'Make-up', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (27, 8, 7, 'Paint Brushes', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (28, 8, 7, 'Radio', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);
INSERT INTO item (item_id, list_id, added_by, item_name, item_quantity, category, date_added, completed, last_modified, last_modified_by)
    VALUES (29, 8, 7, 'Music Box', 1, 'misc', default, 'false', '2022-12-08 12:45:24.914091', null);



COMMIT TRANSACTION;
