
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema ASPRAPP
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ASPRAPP` DEFAULT CHARACTER SET utf8 ;
USE `ASPRAPP` ;

-- -----------------------------------------------------
-- Tabla Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASPRAPP`.`usuario` (
  `nombre` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla Motivo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASPRAPP`.`motivo` (
  `id_motivo` INT NOT NULL,
  `tipo` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`id_motivo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla Reportes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASPRAPP`.`reportes` (
  `id_reporte` INT NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(150) NOT NULL,
  `email_usuario` VARCHAR(45) NOT NULL,
  `id_motivo` INT NOT NULL,
  PRIMARY KEY (`id_reporte`),
  INDEX `fk_reportes_usuario_idx` (`email_usuario` ASC) VISIBLE,
  INDEX `fk_id_motivo_idx` (`id_motivo` ASC) VISIBLE,
  CONSTRAINT `fk_reportes_usuario`
    FOREIGN KEY (`email_usuario`)
    REFERENCES `ASPRAPP`.`usuario` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_motivo`
    FOREIGN KEY (`id_motivo`)
    REFERENCES `ASPRAPP`.`motivo` (`id_motivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
