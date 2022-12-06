BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, shopping_group, shopping_group_users, list, item;

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	email varchar(200) UNIQUE,
	CONSTRAINT uq_email UNIQUE (email),
	CONSTRAINT uq_username UNIQUE (username),
	CONSTRAINT ch_email CHECK (email like '%@%.%')
);

CREATE TABLE shopping_group (
    group_id serial NOT NULL PRIMARY KEY,
	group_name varchar(200),
    invitation_code int NOT NULL
);

CREATE TABLE shopping_group_users (
    shopping_group_users_id serial PRIMARY KEY,
    group_id int NOT NULL,
    user_id int NOT NULL,
    date_joined date NOT NULL DEFAULT CURRENT_DATE,

    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES shopping_group (group_id)
);

CREATE TABLE list (
    list_id serial NOT NULL PRIMARY KEY,
    list_name varchar(200) NOT NULL,
    group_id int NOT NULL,
    claimed boolean DEFAULT FALSE,
	list_owner int,
	completed boolean DEFAULT FALSE,

    CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES shopping_group (group_id),
	CONSTRAINT fk_list_owner FOREIGN KEY (list_owner) REFERENCES  users (user_id)

);

CREATE TABLE item (
    item_id serial NOT NULL PRIMARY KEY,
    list_id int NOT NULL,
	added_by INT NOT NULL,
    item_name varchar (100) NOT NULL,
	item_quantity int NOT NULL DEFAULT 1,
	category varchar (100),
	date_added date NOT NULL DEFAULT CURRENT_DATE,
	completed boolean DEFAULT false,

    CONSTRAINT fk_list_id FOREIGN KEY (list_id) REFERENCES list (list_id),
	CONSTRAINT fk_added_by FOREIGN KEY (added_by) REFERENCES users (user_id)

);

COMMIT TRANSACTION;
