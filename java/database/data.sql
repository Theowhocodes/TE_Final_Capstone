BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (user_id, username, password_hash, role, email) VALUES (default, 'testuser1', 12345, 'ROLE_USER', 'test1@test.com');
INSERT INTO users (user_id, username, password_hash, role, email) VALUES (default, 'testuser2', 12345, 'ROLE_USER', 'test2@test.com');
INSERT INTO users (user_id, username, password_hash, role, email) VALUES (default, 'testuser3', 12345, 'ROLE_USER', 'test3@test.com');

INSERT INTO shopping_group (group_id, group_name, invitation_code) VALUES (default, 'test group 1', 98765);
INSERT INTO shopping_group (group_id, group_name, invitation_code) VALUES (default, 'test group 2', 87654);

INSERT INTO shopping_group_users (group_id, user_id, date_joined) VALUES (1, 1, default);

COMMIT TRANSACTION;
