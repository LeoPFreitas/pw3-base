create table if not exists users
(
    id       int auto_increment
        primary key,
    nome     varchar(50) null,
    email    varchar(50) null,
    password varchar(50) null
);

INSERT INTO users(name, email, password) VALUES ('Leonardo', 'leonardo@leonardo.com', 'senha');
INSERT INTO users(name, email, password) VALUES ('Leonardo1', 'leonardo1@leonardo.com', 'senha1');
INSERT INTO users(name, email, password) VALUES ('Leonardo2', 'leonardo2@leonardo.com', 'senha2');
INSERT INTO users(name, email, password) VALUES ('Leonardo3', 'leonardo3@leonardo.com', 'senha3');
INSERT INTO users(name, email, password) VALUES ('Leonardo4', 'leonardo4@leonardo.com', 'senha4');