CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;

CREATE TABLE IF NOT EXISTS employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    salary DOUBLE
);

INSERT INTO employee VALUES
(1, 'Jahnvi', 55000),
(2, 'Aarav', 60000);
