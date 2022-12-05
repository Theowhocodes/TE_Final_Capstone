BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, shopping_group, shopping_group_users, list, item;

CREATE TABLE users (
	user_id SERIAL NOT NULL PRIMARY KEY,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	email varchar(200) UNIQUE,
	CONSTRAINT uq_email UNIQUE (email),
	CONSTRAINT uq_username UNIQUE (username),
	CONSTRAINT ch_email CHECK (email like '%@%.%')
);

CREATE TABLE shopping_group_users (
    group_id serial NOT NULL PRIMARY KEY,
    user_id integer NOT NULL REFERENCES users(user_id),
    date_joined date NOT NULL DEFAULT CURRENT_DATE,
);

CREATE TABLE shopping_group (
    group_id integer NOT NULL REFERENCES shopping_group_users(group_id),
	group_name varchar(200) NOT NULL UNIQUE,
    invitation_code SERIAL NOT NULL,
    CONSTRAINT uq_group_name UNIQUE (group_name)
);

CREATE TABLE list (
    list_id serial NOT NULL PRIMARY KEY,
    list_name varchar(200) NOT NULL,
    group_id integer NOT NULL REFERENCES shopping_group_users(group_id),
    claimed boolean DEFAULT FALSE,
	list_owner integer REFERENCES users(user_id),
	completed boolean DEFAULT FALSE,

);

CREATE TABLE item (
    item_id serial NOT NULL PRIMARY KEY,
    list_id integer NOT NULL REFERENCES list(list_id),
	added_by integer NOT NULL REFERENCES users(user_id),
    item_name varchar (100) NOT NULL,
	item_quantity int NOT NULL DEFAULT 1,
	date_added date NOT NULL DEFAULT CURRENT_DATE,
	completed boolean DEFAULT false,

);

COMMIT TRANSACTION;
