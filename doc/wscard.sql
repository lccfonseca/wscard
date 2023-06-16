-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema geticard
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema geticard
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `geticard` DEFAULT CHARACTER SET utf8 ;
USE `geticard` ;

-- -----------------------------------------------------
-- Table `geticard`.`card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geticard`.`card` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `phone` VARCHAR(25) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `minibio` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `geticard`.`social`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geticard`.`social` (
  `id` BIGINT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `icon` VARCHAR(150) NOT NULL,
  `url` VARCHAR(150) NOT NULL,
  `profiles_url` VARCHAR(150) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `geticard`.`card_social`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geticard`.`card_social` (
  `id` BIGINT NOT NULL,
  `card_id` BIGINT NOT NULL,
  `social_id` BIGINT NOT NULL,
  `profile` VARCHAR(150) NOT NULL,
  `label` VARCHAR(25) NULL,
  INDEX `fk_card_has_social_social1_idx` (`social_id` ASC) VISIBLE,
  INDEX `fk_card_has_social_card_idx` (`card_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_card_has_social_card`
    FOREIGN KEY (`card_id`)
    REFERENCES `geticard`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_card_has_social_social1`
    FOREIGN KEY (`social_id`)
    REFERENCES `geticard`.`social` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
