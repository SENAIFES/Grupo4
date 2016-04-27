CREATE SCHEMA IF NOT EXISTS `dbchecklist` DEFAULT CHARACTER SET latin1 ;
USE `dbchecklist` ;

-- -----------------------------------------------------
-- Table `dbchecklist`.`tarefa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbchecklist`.`tarefa` (
  `idtarefa` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `data` DATE NOT NULL,
  `feito` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idtarefa`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;
