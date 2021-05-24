create database if not exists pw3;
use pw3;
CREATE TABLE users
(
    id       int auto_increment not null,
    name     varchar(30)        not null,
    username varchar(20),
    password varchar(60),
    primary key (id)
);

CREATE TABLE employee
(
    id        int auto_increment not null primary key,
    firstName varchar(50),
    lastName  varchar(50),
    age       int,
    jobTitle  varchar(50)
);

