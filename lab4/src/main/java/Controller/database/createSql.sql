CREATE DATABASE IF NOT EXISTS flightradar24;
USE flightradar24;
DROP TABLE IF EXISTS secret_password;
DROP TABLE IF EXISTS traveler;
DROP TABLE IF EXISTS current;
DROP TABLE IF EXISTS point;
DROP TABLE IF EXISTS airplane;
DROP TABLE IF EXISTS airline;
DROP TABLE IF EXISTS owner;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS airplane_category;
DROP TABLE IF EXISTS route;

CREATE TABLE country (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  language VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE city (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  region VARCHAR(45) NOT NULL,
  country_id INT NULL,
  foreign key (country_id) references country(id) on delete cascade,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE owner (
  id INT NOT NULL AUTO_INCREMENT,
  full_name VARCHAR(200) NOT NULL,
  age INT NULL,
  live_adress VARCHAR(45) NULL,
  email VARCHAR(100) NULL,
  phone VARCHAR(100) NULL,
  country_id INT NULL,
  city_id INT NULL,
  foreign key (country_id) references country(id) on delete cascade,
  foreign key (city_id) references city(id) on delete cascade,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE airline (
  id INT NOT NULL AUTO_INCREMENT,
  partership INT NULL,
  name VARCHAR(105) NOT NULL,
  registration_date VARCHAR(45) NOT NULL,
  registration_country VARCHAR(45) NOT NULL,
  company_revenue INT NULL,
  owner_id INT NULL,
  foreign key (owner_id) references owner(id) on delete cascade,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE airplane_category (
  id INT NOT NULL AUTO_INCREMENT,
  type VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE route (
  id INT NOT NULL AUTO_INCREMENT,
  scheduled_from VARCHAR(45) NOT NULL,
  scheduled_to VARCHAR(45) NOT NULL,
  actual INT NOT NULL,
  estimated INT NOT NULL,
  departure_from VARCHAR(45) NOT NULL,
  arrival_to VARCHAR(45) NOT NULL,
  total_distance INT NOT NULL,
  passed_distance INT NOT NULL,
  date VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE airplane (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) BINARY NOT NULL,
  registration_date VARCHAR(45) NOT NULL,
  registration_country VARCHAR(45) NOT NULL,
  serial_number VARCHAR(200) NOT NULL,
  age INT NULL,
  airplane_category_id INT NULL,
  airline_id INT NULL,
  route_id INT NULL,
  foreign key (airplane_category_id) references airplane_category(id) on delete cascade,
  foreign key (airline_id) references airline(id) on delete cascade,
  foreign key (route_id) references route(id) on delete cascade,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE traveler (
  id INT NOT NULL AUTO_INCREMENT,
  full_name VARCHAR(200) NOT NULL,
  email VARCHAR(105) NOT NULL,
  language VARCHAR(45) NOT NULL,
  photo_url VARCHAR(45) NOT NULL,
  subscription_end VARCHAR(45) NOT NULL,
  plan VARCHAR(45) NOT NULL,
  start_at VARCHAR(45) NOT NULL,
  updated_at VARCHAR(45) NULL,
  deleted_at VARCHAR(45) NULL,
  subscription_start VARCHAR(45) NOT NULL,
  airplane_id INT NULL,
  airline_id INT NULL,
  foreign key (airplane_id) references airplane(id) on delete cascade,
  foreign key (airline_id) references airline(id) on delete cascade,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE secret_password (
  password VARCHAR(45) NOT NULL,
  traveler_id INT NULL,
  foreign key (traveler_id) references traveler(id) on delete cascade)
ENGINE = InnoDB;

CREATE TABLE point (
  id INT NOT NULL AUTO_INCREMENT,
  airport VARCHAR(45) NOT NULL,
  route_id INT NOT NULL,
  city_id INT NULL,
  foreign key (route_id) references route(id) on delete cascade,
  foreign key (city_id) references city(id) on delete cascade,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE current (
  id INT NOT NULL AUTO_INCREMENT,
  wind INT NOT NULL,
  temperature INT NOT NULL,
  latitude FLOAT NOT NULL,
  longtitude FLOAT NOT NULL,
  vertical_speed INT NOT NULL,
  gps_altitude INT NOT NULL,
  track INT NOT NULL,
  ground_speed INT NOT NULL,
  true_speed INT NOT NULL,
  indicated_speed INT NOT NULL,
  march INT NOT NULL,
  calibrated_altitude INT NOT NULL,
  icao INT NOT NULL,
  squawk INT NOT NULL,
  date_time VARCHAR(45) NOT NULL,
  airplane_id INT NULL,
  foreign key (airplane_id) references airplane(id) on delete cascade,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


INSERT INTO route (id, scheduled_from, scheduled_to, actual, estimated, departure_from, arrival_to, total_distance, passed_distance, date) VALUES 
(1, '3 AM', '6 AM', 60000, 56000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29'),
(2, '3 AM', '6 AM', 56000, 54000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29'),
(3, '3 AM', '6 AM', 56000, 54000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29'),
(4, '3 AM', '6 AM', 56000, 54000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29'),
(5, '3 AM', '6 AM', 56000, 54000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29'),
(6, '3 AM', '6 AM', 56000, 54000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29'),
(7, '3 AM', '6 AM', 56000, 54000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29'),
(8, '3 AM', '6 AM', 56000, 54000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29'),
(9, '3 AM', '6 AM', 56000, 54000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29'),
(10, '3 AM', '6 AM', 56000, 54000, 'Lviv', 'Odesa', 1100, 147, '2019/09/29');

INSERT INTO country (id, name, language) VALUES 
(1, 'Ukraine', 'uk'),
(2, 'Ukraine', 'uk'),
(3, 'Ukraine', 'uk'),
(4, 'Ukraine', 'uk'),
(5, 'Ukraine', 'uk'),
(6, 'Ukraine', 'uk'),
(7, 'Ukraine', 'uk'),
(8, 'Ukraine', 'uk'),
(9, 'Ukraine', 'uk'),
(10, 'Ukraine', 'uk');

INSERT INTO city (id, name, region, country_id) VALUES
(1, 'Lviv', 'Lvivska', 1),
(2, 'Lviv', 'Lvivska', 2),
(3, 'Lviv', 'Lvivska', 3),
(4, 'Lviv', 'Lvivska', 4),
(5, 'Lviv', 'Lvivska', 5),
(6, 'Lviv', 'Lvivska', 6),
(7, 'Lviv', 'Lvivska', 7),
(8, 'Lviv', 'Lvivska', 8),
(9, 'Lviv', 'Lvivska', 9),
(10, 'Lviv', 'Lvivska', 10);

INSERT INTO owner (id, full_name, age, live_adress, email, phone, country_id, city_id) VALUES
(1, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 1, 1),
(2, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 2, 2),
(3, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 3, 3),
(4, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 4, 4),
(5, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 5, 5),
(6, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 6, 6),
(7, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 7, 7),
(8, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 8, 8),
(9, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 9, 9),
(10, 'Petro Hufka', 42, 'Lviv, Technichna 11', 'chavka@ukr.net', '+380687589422', 10, 10);

INSERT INTO airline (id, partership, name, registration_date, registration_country, company_revenue, owner_id) VALUES
(1, 1, 'Eva', '2000/02/01', 'Poland', 2000000, 1),
(2, 2, 'Eva', '2000/02/01', 'Poland', 2000000, 2),
(3, 3, 'Eva', '2000/02/01', 'Poland', 2000000, 3),
(4, 4, 'Eva', '2000/02/01', 'Poland', 2000000, 4),
(5, 5, 'Eva', '2000/02/01', 'Poland', 2000000, 5),
(6, 6, 'Eva', '2000/02/01', 'Poland', 2000000, 6),
(7, 7, 'Eva', '2000/02/01', 'Poland', 2000000, 7),
(8, 8, 'Eva', '2000/02/01', 'Poland', 2000000, 8),
(9, 9, 'Eva', '2000/02/01', 'Poland', 2000000, 9),
(10, 10, 'Eva', '2000/02/01', 'Poland', 2000000, 10);

INSERT INTO airplane_category (id, type) VALUES 
(1, 'ls'),
(2, 'ls'),
(3, 'ls'),
(4, 'ls'),
(5, 'ls'),
(6, 'ls'),
(7, 'ls'),
(8, 'ls'),
(9, 'ls'),
(10, 'ls');

INSERT INTO airplane (id, name, registration_date, registration_country, serial_number, age, airplane_category_id, airline_id, route_id) VALUES
(1, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 1, 1, 1), 
(2, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 2, 2, 2),
(3, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 3, 3, 3),
(4, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 4, 4, 4),
(5, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 5, 5, 5),
(6, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 6, 6, 6),
(7, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 7, 7, 7),
(8, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 8, 8, 8),
(9, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 9, 9, 9),
(10, 'Boing 5060', '2001', 'Ukraine', 'sdgfdhgf3412dsd', 18, 10, 10, 10);

INSERT INTO traveler (id, full_name, email, language, photo_url, subscription_end, plan, start_at, updated_at, deleted_at, subscription_start, airplane_id, airline_id) VALUES
(1, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 1, 1),
(2, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 2, 2),
(3, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 3, 3),
(4, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 4, 4),
(5, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 5, 5),
(6, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 6, 6),
(7, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 7, 7),
(8, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 8, 8),
(9, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 9, 9),
(10, 'Daniel Nikulshyn', 'nikulshyn.daniel@gmail.com',  'uk', 'http://www.lp.edu.ua/242plakati.png', '2019/12/12', 'profi', '2019/01/01', 'none', 'none', '2019/01/01', 10, 10);


INSERT INTO secret_password (password, traveler_id) VALUES
('#test#', 1),
('melittlepassword', 2),
('fortezza', 3),
('buggylob', 4),
('#testerpro', 5),
('mezolisa', 6),
('pikatchu', 7),
('auduyt', 8),
('ramms', 9),
('animas', 10);

INSERT INTO current (id, wind, temperature, latitude, longtitude, vertical_speed, gps_altitude, track, ground_speed, true_speed, indicated_speed, march, calibrated_altitude, icao, squawk, date_time, airplane_id) VALUES
(1, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 1),
(2, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 2),
(3, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 3),
(4, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 4),
(5, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 5),
(6, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 6),
(7, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 7),
(8, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 8),
(9, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 9),
(10, 10, 20, 10.5, 30.9, 300, 40.3, 200, 340, 320, 325, 25, 23.6, 23, 43, '2019/09/29', 10);

INSERT INTO point (id, airport, route_id, city_id) VALUES
(1, 'Lvivskyj', 1, 1),
(2, 'Lvivskyj', 2, 2),
(3, 'Lvivskyj', 3, 3),
(4, 'Lvivskyj', 4, 4),
(5, 'Lvivskyj', 5, 5),
(6, 'Lvivskyj', 6, 6),
(7, 'Lvivskyj', 7, 7),
(8, 'Lvivskyj', 8, 8),
(9, 'Lvivskyj', 9, 9),
(10, 'Lvivskyj', 10, 10);