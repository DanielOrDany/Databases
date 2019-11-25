-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ksa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ksa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ksa` DEFAULT CHARACTER SET utf8 ;
USE `ksa` ;

-- -----------------------------------------------------
-- Table `ksa`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ksa`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  `degree` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ksa`.`discipline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ksa`.`discipline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `iddisciplines_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ksa`.`seniority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ksa`.`seniority` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `job` VARCHAR(45) NOT NULL,
  `work_time` INT NOT NULL,
  `dismissal_reason` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idseniority_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ksa`.`acceptance_form`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ksa`.`acceptance_form` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `approved_by` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idacceptance_form_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ksa`.`semester`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ksa`.`semester` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `number` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idsemester_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
