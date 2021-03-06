-- MySQL Script generated by MySQL Workbench
-- Sat Jun 27 12:32:29 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema nutritech
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nutritech
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nutritech` DEFAULT CHARACTER SET utf8 ;
USE `nutritech` ;

-- -----------------------------------------------------
-- Table `nutritech`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nutritech`.`USER` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FULLNAME` VARCHAR(100) NOT NULL,
  `EMAIL` VARCHAR(100) NOT NULL,
  `BIRTHDATE` DATE NOT NULL,
  `PASSWORD` VARCHAR(500) NOT NULL,
  `GENDER` VARCHAR(100) NOT NULL,
  `HEIGHT` DECIMAL(7,2) NOT NULL,
  `ISVEGETARIAN` TINYINT(1) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nutritech`.`MOTIVATIONAL_QUOTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nutritech`.`MOTIVATIONAL_QUOTE` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `MESSAGE` VARCHAR(2000) NOT NULL,
  `AUTHOR` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nutritech`.`WEIGHT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nutritech`.`WEIGHT` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `VALUE` DECIMAL(7,2) NOT NULL,
  `DATE` DATE NOT NULL,
  `USER_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `USER_ID`),
  INDEX `fk_WEIGHT_USER1_idx` (`USER_ID` ASC) VISIBLE,
  CONSTRAINT `fk_WEIGHT_USER1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `nutritech`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nutritech`.`DIET`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nutritech`.`DIET` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `URL` VARCHAR(2000) NOT NULL,
  `TYPE` VARCHAR(200) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nutritech`.`USER_DIET`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nutritech`.`USER_DIET` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `USER_ID` INT NOT NULL,
  `DIET_ID` INT NOT NULL,
  `DATE` DATE NOT NULL,
  PRIMARY KEY (`ID`, `USER_ID`, `DIET_ID`),
  INDEX `fk_USER_has_DIET_DIET1_idx` (`DIET_ID` ASC) VISIBLE,
  INDEX `fk_USER_has_DIET_USER_idx` (`USER_ID` ASC) VISIBLE,
  CONSTRAINT `fk_USER_has_DIET_USER`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `nutritech`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_has_DIET_DIET1`
    FOREIGN KEY (`DIET_ID`)
    REFERENCES `nutritech`.`DIET` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `user` VALUES (1,'Alessandro','alessandro0014@hotmail.com','2000-05-31','$2a$10$dSmuDIKyAuBGk2qqjJLL/ObwkoX/aUk/DPN2Hq6htRux9wJ8UikDa','MASCULINO',1.78,0);
insert into motivational_quote values (1, 'Nem todos que tentaram, conseguiram...Mas aqueles que conseguiram, tentaram.', 'Autor desconhecido');
insert into motivational_quote values (2, 'Não encontro defeitos. Encontro soluções. Qualquer um sabe queixar-se..', 'Henry Ford');
insert into motivational_quote values (3, 'Para mim viver é estar contínuamente motivado. O significado da vida não é simplismente existir, sobreviver, mais sim crescer, alcançar e conquistar.', 'Arnold Schwarzenegger ');