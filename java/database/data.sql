BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (user_id, username, password_hash, role, email) VALUES (default, 'testuser1', 12345, 'ROLE_USER', 'test1@test.com');
INSERT INTO users (user_id, username, password_hash, role, email) VALUES (default, 'testuser2', 12345, 'ROLE_USER', 'test2@test.com');
INSERT INTO users (user_id, username, password_hash, role, email) VALUES (default, 'testuser3', 12345, 'ROLE_USER', 'test3@test.com');

INSERT INTO shopping_group (group_id, group_name, invitation_code) VALUES (default, 'test group 1', 83472);
INSERT INTO shopping_group (group_id, group_name, invitation_code) VALUES (default, 'test group 2', 23928);
INSERT INTO shopping_group (group_id, group_name, invitation_code) VALUES (default, 'test group 3', 13232);

INSERT INTO shopping_group_users (group_id, user_id, date_joined) VALUES(1, 1, default);
INSERT INTO shopping_group_users (group_id, user_id, date_joined) VALUES(2, 1, default);
INSERT INTO shopping_group_users (group_id, user_id, date_joined) VALUES(3, 2, default);
INSERT INTO shopping_group_users (group_id, user_id, date_joined) VALUES(1, 2, default);
INSERT INTO shopping_group_users (group_id, user_id, date_joined) VALUES(2, 3, default);
INSERT INTO shopping_group_users (group_id, user_id, date_joined) VALUES(3, 3, default);

INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(1, 'list1', 1, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(2, 'list2', 1, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(3, 'list3', 2, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(4, 'list4', 2, 'false', null, 'false');
INSERT INTO list (list_id, list_name, group_id, claimed, list_owner, completed) VALUES(5, 'list5', 3, 'false', null, 'false');

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
COMMIT TRANSACTION;
