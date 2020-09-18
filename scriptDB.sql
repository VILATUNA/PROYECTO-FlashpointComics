DROP SEQUENCE public.sec_comic cascade;
DROP Table public.comic cascade;

/**
*
*CREACION DE LAS TABLAS DE COMIC Y USUARIO
*
**/
CREATE SEQUENCE public.sec_comic
	START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.sec_comic
    OWNER TO postgres;

CREATE TABLE COMIC (
	id_comic integer primary key NOT NULl DEFAULT nextval('public.sec_comic'::regclass),
	cmc_titulo varchar(100),
	cmc_autor varchar(100),
	cmc_resumen varchar(100),
	cmc_edicion varchar(100),
	cmc_idioma varchar(100),
	cmc_fecha_publicacion varchar(100),
	cmc_num_paginas integer,
	cmc_imagen varchar(100),
	cmc_comic varchar(100)
);

CREATE TABLE Usuario(
	id serial,
	nombre varchar(40),
	email varchar(40),
	contraseña varchar(40)
);






