SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema asprapp
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `asprapp`;
CREATE SCHEMA IF NOT EXISTS `asprapp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `asprapp`;

-- -----------------------------------------------------
-- Table `asprapp`.`motivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asprapp`.`motivo` (
  `id_motivo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`id_motivo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

-- -----------------------------------------------------
-- Table `asprapp`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asprapp`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

-- -----------------------------------------------------
-- Table `asprapp`.`reporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asprapp`.`reporte` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `id_motivo` INT NOT NULL,
  `descripcion` VARCHAR(150) NOT NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_motivo_idx` (`id_motivo` ASC),
  INDEX `fk_reportes_usuario_idx` (`id_usuario` ASC),
  CONSTRAINT `fk_reportes_motivo`
    FOREIGN KEY (`id_motivo`)
    REFERENCES `asprapp`.`motivo` (`id_motivo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_reportes_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `asprapp`.`usuario` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;