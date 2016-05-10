CREATE SCHEMA IF NOT EXISTS `dbtarefa` DEFAULT CHARACTER SET latin1 ;
USE `dbtarefa` ;

-- -----------------------------------------------------INSERT INTO `dbtarefa`.`tarefa` (`Descrisao`, `Prazo`, `Feito`, `idLista
-- Table `dbchecklist`.`tarefa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtarefa`.`tarefa` (
  `idtarefa` INT(11) NOT NULL AUTO_INCREMENT,
  `Descrisao` VARCHAR(45) NOT NULL,
  `Prazo` DATE NOT NULL,
  `feito` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idtarefa`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;
CREATE TABLE `dbtarefa`.`lista` (
  `idLista` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idLista`))
