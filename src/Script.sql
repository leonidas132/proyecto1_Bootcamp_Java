create database if not exists protalento;
use protalento;

-- drop table if exists usuarios;
-- drop table if exists categorias;

create table if not exists usuarios(
    correo varchar (100) not null primary key,
    clave blob not null,
    fechaCreacion date not null
    );

create table if not exists categorias(
     id bigint auto_increment primary key,
     descripcion varchar(100)
    );