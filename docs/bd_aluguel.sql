-- MySQL Script generated by MySQL Workbench
-- 12/13/15 16:00:10
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema aluguel
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `aluguel` ;
CREATE SCHEMA IF NOT EXISTS `aluguel` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `aluguel` ;

-- -----------------------------------------------------
-- Table `aluguel`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aluguel`.`cliente` ;

CREATE TABLE IF NOT EXISTS `aluguel`.`cliente` (
  `id` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aluguel`.`carro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aluguel`.`carro` ;

CREATE TABLE IF NOT EXISTS `aluguel`.`carro` (
  `id` INT NOT NULL,
  `fabricante` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `ano` YEAR NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `situacao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aluguel`.`aluguel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aluguel`.`aluguel` ;

CREATE TABLE IF NOT EXISTS `aluguel`.`aluguel` (
  `cliente_id` INT NOT NULL,
  `carro_id` INT NOT NULL,
  `data_inicio` DATE NULL,
  `data_fim` DATE NULL,
  PRIMARY KEY (`cliente_id`, `carro_id`))
ENGINE = InnoDB;

CREATE INDEX `fk_cliente_has_carro_carro1_idx` ON `aluguel`.`aluguel` (`carro_id` ASC);

CREATE INDEX `fk_cliente_has_carro_cliente_idx` ON `aluguel`.`aluguel` (`cliente_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
