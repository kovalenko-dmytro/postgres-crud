CREATE DATABASE bookstore_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.books

-- DROP TABLE public.books;

CREATE TABLE public.books
(
    id integer NOT NULL DEFAULT nextval('books_id_seq'::regclass),
    title character varying(100) COLLATE pg_catalog."default" NOT NULL,
    author character varying(100) COLLATE pg_catalog."default" NOT NULL,
    cost numeric(8,2) NOT NULL,
    CONSTRAINT books_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.books
    OWNER to postgres;