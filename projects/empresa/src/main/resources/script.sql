create database empresa;

CREATE TABLE users
(
    id       int auto_increment not null,
    nome     varchar(30)        not null,
    email    varchar(100),
    cpf      varchar(15),
    username varchar(10),
    password varchar(60),
    primary key (id)
);

