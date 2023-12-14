CREATE DATABASE IF NOT EXISTS final;
USE final;

CREATE TABLE estudiantes (
id INT auto_increment PRIMARY KEY,
apellido VARCHAR(255),
nombre VARCHAR(255),
email VARCHAR(255));

INSERT INTO estudiantes(nombre, apellido, email)
VALUES ("Natalia", "Garcia", "natalia@gmail.com"),
("Pedro", "Sarmiento", "ps12@gmail.com"),
("Micaela", "Lopez", "mlopez@hotmail.com"),
("Juan", "Casas", "jcc@outlook.com");