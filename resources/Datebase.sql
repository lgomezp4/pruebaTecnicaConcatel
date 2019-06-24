/**
 * Author:  Luis Gómez
 * Created: 23-jun-2019
 */

CREATE USER 'testuser'@'localhost' IDENTIFIED BY 'testpsw';

CREATE DATABASE BackEndExam3
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT SELECT, INSERT, UPDATE, DELETE ON BackEndExam3.* TO 'testuser'@'localhost';  

USE BackEndExam3;

CREATE TABLE logEntry (
    id INTEGER PRIMARY KEY auto_increment,
    name VARCHAR(50) NOT NULL,
    planet VARCHAR(50) NOT NULL,
    datetime TIMESTAMP NOT NULL     
) ENGINE=InnoDb;