-- MySQL Script generated by MySQL Workbench
-- 08/04/18 13:51:42
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema taxi_park_schema
-- -----------------------------------------------------
-- Служба такси. 
-- Описание предметной области.
-- Служба такси предоставляет услуги перевозки клиентов. Каждый конкретный перевозчик является водителем, и имеет один или несколько автомобилей. Каждый автомобиль имеет свой личный номер, марку(модель), год выпуска и идентификационный номер владельца. Каждый водитель имеет свой идентификационный номер, имя, определенное количество опыта(стаж) и информация о активности водителя (есть ли бан, активен ли на данный момент либо занят или не работает). Нашими клиентами являются различные лица и каждый имеет свой личный идентификационный номер, по которому легко можно отследить его поездки. Мы собираем некоторую информацию о каждом клиенте (имя и номер телефона) с помощью которой мы можем найти клиента в базе данных и узнать есть ли на клиенте бан, размер скидки и общее количество поездок. Так же мы собираем информацию о самих поездках, где у каждой поездки есть свой идентификационный номер зная который мы можем выяснить,  кто был или есть(если поездка выполняется сейчас) водителем и клиентом(по идентификационным номерам), а так же цену поездки и статус-результат(выполняется ли сейчас, окончена и оплачена либо окончена и не оплачена)
-- 
DROP SCHEMA IF EXISTS `taxi_park_schema` ;

-- -----------------------------------------------------
-- Schema taxi_park_schema
--
-- Служба такси. 
-- Описание предметной области.
-- Служба такси предоставляет услуги перевозки клиентов. Каждый конкретный перевозчик является водителем, и имеет один или несколько автомобилей. Каждый автомобиль имеет свой личный номер, марку(модель), год выпуска и идентификационный номер владельца. Каждый водитель имеет свой идентификационный номер, имя, определенное количество опыта(стаж) и информация о активности водителя (есть ли бан, активен ли на данный момент либо занят или не работает). Нашими клиентами являются различные лица и каждый имеет свой личный идентификационный номер, по которому легко можно отследить его поездки. Мы собираем некоторую информацию о каждом клиенте (имя и номер телефона) с помощью которой мы можем найти клиента в базе данных и узнать есть ли на клиенте бан, размер скидки и общее количество поездок. Так же мы собираем информацию о самих поездках, где у каждой поездки есть свой идентификационный номер зная который мы можем выяснить,  кто был или есть(если поездка выполняется сейчас) водителем и клиентом(по идентификационным номерам), а так же цену поездки и статус-результат(выполняется ли сейчас, окончена и оплачена либо окончена и не оплачена)
-- 
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `taxi_park_schema` DEFAULT CHARACTER SET utf8 ;
USE `taxi_park_schema` ;

-- -----------------------------------------------------
-- Table `taxi_park_schema`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `taxi_park_schema`.`customer` ;

CREATE TABLE IF NOT EXISTS `taxi_park_schema`.`customer` (
  `customer_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Идентификационный номер клиента',
  `name` VARCHAR(20) NOT NULL COMMENT 'Имя клиента. Для того чтобы потом проверить на наличие бана или скидки по одному из параметров (имя или номер телефона).',
  `phone_number` VARCHAR(20) NOT NULL COMMENT 'Номер телефона клиента. Для того чтобы потом проверить на наличие бана или скидки по одному из параметров (имя  или номер телефона).',
  `status` VARCHAR(45) NOT NULL COMMENT 'Статус: есть ли на клиенте бан',
  `discount` INT(11) NOT NULL COMMENT 'Процент скидки',
  `trip_number` INT(11) NOT NULL COMMENT 'Количество совершенных поездок',
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Описание клиента такси';


-- -----------------------------------------------------
-- Table `taxi_park_schema`.`taxi_drivers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `taxi_park_schema`.`taxi_drivers` ;

CREATE TABLE IF NOT EXISTS `taxi_park_schema`.`taxi_drivers` (
  `driver_id` INT(50) NOT NULL AUTO_INCREMENT COMMENT 'Идентификационный номер водителя',
  `driver_name` VARCHAR(45) NOT NULL COMMENT 'Имя водителя',
  `experience` INT(25) NOT NULL COMMENT 'Опыт вождения',
  `status` VARCHAR(45) NOT NULL COMMENT 'Информация о активности водителя (есть ли бан, активен ли на данный момент, либо занят или не работает)',
  `driver_password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`driver_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Таблица с описанием водителя такси';


-- -----------------------------------------------------
-- Table `taxi_park_schema`.`taxi_cars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `taxi_park_schema`.`taxi_cars` ;

CREATE TABLE IF NOT EXISTS `taxi_park_schema`.`taxi_cars` (
  `car_id` INT(100) NOT NULL AUTO_INCREMENT COMMENT 'Идентификационный номер авто',
  `owner_id` INT(11) NOT NULL COMMENT 'Идентификационный номер владельца авто',
  `model` VARCHAR(45) NOT NULL COMMENT 'Марка автомобиля',
  `year` INT(11) NOT NULL COMMENT 'Год выпуска',
  PRIMARY KEY (`car_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Таблица с описанием автомобилей-такси';


-- -----------------------------------------------------
-- Table `taxi_park_schema`.`taxi_trips`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `taxi_park_schema`.`taxi_trips` ;

CREATE TABLE IF NOT EXISTS `taxi_park_schema`.`taxi_trips` (
  `trip_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Личный номер поездки',
  `driver_id` INT(11) NOT NULL COMMENT 'Идентификационный номер водителя во время поездки',
  `customer_id` INT NOT NULL COMMENT 'Идентификационный номер  клиента во время поездки',
  `price` DOUBLE NOT NULL COMMENT 'Цена поездки',
  `status` VARCHAR(20) NOT NULL COMMENT 'Статус поездки на даннный момент(в процессе, выполнено)',
  PRIMARY KEY (`trip_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Поездки. Выполненные и текущие';


-- -----------------------------------------------------
-- Table `taxi_park_schema`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `taxi_park_schema`.`admin` ;

CREATE TABLE IF NOT EXISTS `taxi_park_schema`.`admin` (
  `admin_name` VARCHAR(20) NOT NULL,
  `admin_password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`admin_name`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



select * from admin;
select * from taxi_drivers;
select * from taxi_cars;



select car_id, model, owner_id, year from taxi_cars where owner_id=1;