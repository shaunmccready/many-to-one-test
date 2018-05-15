-- Run this command seperately
create DATABASE test_db;



-- Run the rest at once if you like. Cannot run the create database because it needs to be done separately.
CREATE USER test_user WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION;

create schema test;

CREATE TABLE test."user"
(
    id serial,
    name text COLLATE pg_catalog."default",
    CONSTRAINT user_id_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

CREATE TABLE test.phone_numbers
(
    id serial,
    user_id integer,
    "number" text COLLATE pg_catalog."default",
    CONSTRAINT phone_numbers_id_pkey PRIMARY KEY (id),
    CONSTRAINT user_id_fkey FOREIGN KEY (user_id)
        REFERENCES test."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
