DROP DATABASE IF EXISTS jazovci;
CREATE DATABASE jazovci;
USE jazovci;
CREATE TABLE potreb(
id INT, 
ime VARCHAR(255), 
pass VARCHAR(255)
);
INSERT INTO potreb VALUES
(1, "admin", "admin");